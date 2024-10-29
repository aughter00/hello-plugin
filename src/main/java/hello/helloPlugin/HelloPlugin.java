package hello.helloPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelloPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello, Plugin!");

        // playerMoveChecker pmc = new playerMoveChecker();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerMoveCheck(PlayerMoveEvent ev) {
        ev.setCancelled(true);
        ev.getPlayer().sendMessage(ChatColor.RED + "Don't move!");
    }

    // @Override
    // public void onDisable() {
    //     // Plugin shutdown logic
    // }
}
