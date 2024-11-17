package hello.helloPlugin;

import com.google.common.net.HttpHeaders;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetAPI {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String OAI_API_MODEL = "gpt-4o-mini";
    private static final Number OAI_API_TEMP = 1.1;
    private static final String OAI_API_SYSTEM_CONTENT = "You are a Minecraft expert, and as a Newbie Guardian, you can explain anything about Minecraft in a very friendly tone of voice. (Use emoticons with special character combinations and be TMI.) If the topic of conversation veers away from Minecraft, say you don't know.";
    private static final String OAI_API_KEY = dotenv.get("OPENAI_API_KEY");

    public static String getUserInfo(String userid, String category) {
        String uri = "http://localhost:1234/" + userid + "/" + category + "/";

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
                    );

            return response.body();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public static String postChatCompletion(String prompt) {
        System.out.println("Prompt: " + prompt);
        System.out.println("API Key: " + OAI_API_KEY);
        String uri = "https://api.openai.com/v1/chat/completions";

        try {

            JSONObject requestBody = new JSONObject();
            requestBody.put("model", OAI_API_MODEL);
            requestBody.put("temperature", OAI_API_TEMP);

            JSONArray messageArray = new JSONArray();
            JSONObject[] messageObjects = new JSONObject[]{
                    new JSONObject()
                            .put("role", "system")
                            .put("content", OAI_API_SYSTEM_CONTENT),
                    new JSONObject()
                            .put("role", "user")
                            .put("content", prompt)
            };
            for(JSONObject m : messageObjects) {
                messageArray.put(m);
            }
            requestBody.put("messages", messageArray);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + OAI_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            JSONObject parsedBody = new JSONObject(response.body());
            JSONArray choices = parsedBody.getJSONArray("choices");
            JSONObject choice0 = choices.getJSONObject(0);
            JSONObject message = choice0.getJSONObject("message");
            String content = message.getString("content");

            return content;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }
}
