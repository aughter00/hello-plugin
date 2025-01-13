package hello.helloPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinChecker implements Listener {
    // extends:    확장하다 (클래스는    실체가 있었는데, 내용을 추가)
    // implements: 구현하다 (인터페이스는 실체가 없었는데, 자세하게 구현)

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {
        Player player = ev.getPlayer();
        String nick = player.getName();

        ev.setJoinMessage("[알림] " + nick + "님이 접속하셨습니다.");
        String msg = nick + "님이 마인크래프트 서버에 접속하셨습니다.";

        String res = GetAPI.postDiscordChannelMessage(msg);
        System.out.println(res);

        // 새로운 플레이어에게 스코어보드 표시하기
        PlayerPrizeBoard.showBoard(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent ev) {
        Player player = ev.getPlayer();
        String nick = player.getName();

        ev.setQuitMessage("[알림] " + nick + "님이 퇴장하셨습니다.");
        String msg = nick + "님이 마인크래프트 서버에서 퇴장하셨습니다.";

        String res = GetAPI.postDiscordChannelMessage(msg);
        System.out.println(res);
    }
}
