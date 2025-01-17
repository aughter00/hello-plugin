package hello.helloPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathChecker implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent ev) {
        if (ev.getEntity() instanceof Player) {
            Player player = (Player) ev.getEntity();
            if (player == null) return;

            Player killer = player.getKiller();
            if (killer == null) return;

            PlayerPrizeBoard.addPrize(killer, 100);
        }
    }
}
