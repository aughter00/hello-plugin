package hello.helloPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.Comparator;
import java.util.HashMap;

public class PlayerPrizeBoard {
    private static ScoreboardManager mg = Bukkit.getScoreboardManager();
    private static Scoreboard sb;
    private static Objective prizeObjective;
    private static HashMap<String, Integer> prizeList = new HashMap<>();
    private static HashMap<String, Integer> prizeListTop10 = new HashMap<>(10);

    public static void showBoard(Player newPlayer) {
        String nick = newPlayer.getName();

        sb = mg.getNewScoreboard();
        prizeObjective = sb.registerNewObjective(
                "PRIZE",
                "DUMMY",
                MessageBeautify.makeMessageGradation("==현상금 수배자==")
        );
        prizeObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // 닉네임으로 현상금 불러오기(최초 접속시: 0원으로 초기화)
        prizeList.getOrDefault(nick, 0);

        newPlayer.setScoreboard(sb);
    }

    public static void updateBoard() {
        // TODO: 상위권 10등 갱신하고, 표시하기!
        // prizeListTop10
    }

    public static void addPrize(Player killer, int value) {
        if (killer != null) {
            String nick = killer.getName();

            // 닉네임으로 현상금 불러오기
            int prize = prizeList.get(nick);
            int newPrize = prize + value;
            prizeList.put(nick, newPrize);

            // 스코어보드에 업데이트 하기
            Score s = prizeObjective.getScore(
                    ChatColor.BOLD.toString() + ChatColor.RED + nick +
                    ChatColor.RESET.toString() + ChatColor.BLACK + " : " +
                    ChatColor.GOLD
            );
            s.setScore(newPrize);
        }
    }
}
