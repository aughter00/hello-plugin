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

        HelloCommand hc = new HelloCommand();
        getCommand("hello").setExecutor(hc);

        String userInfo = getAPI.getUserInfo("Alice", "inventory");
        System.out.println(userInfo);

        String completion = getAPI.postChatCompletion("안녕, 마인크래프트 엔더드래곤 5분 안에 잡는 방법이 뭐니 ㅎㅎ?");
        System.out.println(completion);
    }

    @EventHandler
    public void onPlayerMoveCheck(PlayerMoveEvent ev) {
        ev.setCancelled(true);
        String warnMsg = MessageBeautify.makeMessageGradation("[경고] Don't Move!!!!!", 3);
        ev.getPlayer().sendMessage(ChatColor.BOLD + warnMsg);
    }

    // @Override
    // public void onDisable() {
    //     // Plugin shutdown logic
    // }
}
