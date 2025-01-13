package hello.helloPlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelloPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        System.out.println("Hello, Plugin!");

        // Bukkit.getPluginManager().registerEvents(new PlayerMoveChecker(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinChecker(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathChecker(), this);

        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("guide").setExecutor(new GuideCommand());
    }

    @Override
    public void onDisable() {
    }
}
