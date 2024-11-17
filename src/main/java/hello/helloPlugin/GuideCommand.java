package hello.helloPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String content = "";

        if (args.length == 1) {
            String prompt = args[0];
            content = GetAPI.postChatCompletion(prompt);
        } else return false;

        if (sender instanceof Player p) {
            String fullMsg = "뉴비 수호자: " + content;
            p.sendMessage(MessageBeautify.makeMessageGradation(fullMsg));
        } else {
            System.out.println(content);
        }

        return true;
    }
}
