package hello.helloPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathChecker implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent ev) {
        Player player = ev.getEntity();
        Player killer = player.getKiller();
        PlayerPrizeBoard.addPrize(killer, 100);
    }
}
