package hello.helloPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinChecker implements Listener {
    // extends:    확장하다 (클래스는    실체가 있었는데, 내용을 추가)
    // implements: 구현하다 (인터페이스는 실체가 없었는데, 자세하게 구현)

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {
        String playerName = ev.getPlayer().getName();
        //ev.getPlayer().sendMessage();
        ev.setJoinMessage("[알림] " + playerName + "님이 접속하셨습니다.");
        String msg = playerName + "님이 마인크래프트 서버에 접속하셨습니다.";
        String res = GetAPI.postDiscordChannelMessage(msg);
        System.out.println(res);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent ev) {
        String playerName = ev.getPlayer().getName();
        //ev.getPlayer().sendMessage();
        ev.setQuitMessage("[알림] " + playerName + "님이 퇴장하셨습니다.");
        String msg = playerName + "님이 마인크래프트 서버에서 퇴장하셨습니다.";
        String res = GetAPI.postDiscordChannelMessage(msg);
        System.out.println(res);
    }
}
