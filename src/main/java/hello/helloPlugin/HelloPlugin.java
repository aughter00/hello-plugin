package hello.helloPlugin;

import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelloPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello, Plugin!");

        // PlayerMoveChecker pmc = new playerMoveChecker();
        // Bukkit.getPluginManager().registerEvents(new PlayerMoveChecker(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinChecker(), this);

        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("guide").setExecutor(new GuideCommand());

        // String userInfo = GetAPI.getUserInfo("Alice", "inventory");
        // System.out.println(userInfo);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
