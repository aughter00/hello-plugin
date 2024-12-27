package hello.helloPlugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveChecker implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent ev) {
        ev.setCancelled(true);
        String warnMsg = MessageBeautify.makeMessageGradation("[경고] Don't Move!!!!!", 3);
        ev.getPlayer().sendMessage(ChatColor.BOLD + warnMsg);
    }
}
