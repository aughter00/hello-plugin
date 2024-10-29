package hello.helloPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Array;
import java.util.ArrayList;

public class HelloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("heal")) {
                    p.setHealth(20);
                    p.sendMessage(ChatColor.BOLD + "체력이 회복되었습니다!");
                }
            }

        } else { // Server
            System.out.println("Hello, Server!");
        }
        return true;
    }

}
