package hello.helloPlugin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class getAPI {
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
}
