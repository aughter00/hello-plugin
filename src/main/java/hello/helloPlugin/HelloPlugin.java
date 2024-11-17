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
        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("guide").setExecutor(new GuideCommand());

        // String userInfo = GetAPI.getUserInfo("Alice", "inventory");
        // System.out.println(userInfo);
    }

    /*
    @EventHandler
    public void onPlayerMoveCheck(PlayerMoveEvent ev) {
        ev.setCancelled(true);
        String warnMsg = MessageBeautify.makeMessageGradation("[경고] Don't Move!!!!!", 3);
        ev.getPlayer().sendMessage(ChatColor.BOLD + warnMsg);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    */
}
