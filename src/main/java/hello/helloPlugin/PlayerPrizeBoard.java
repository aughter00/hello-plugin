package hello.helloPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.*;

public class PlayerPrizeBoard {
    public static Integer MAX_PLAYER = 5;

    private static Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
    private static Objective prizeObjective;
    private static HashMap<String, Integer> prizeList = new HashMap<>();
    private static HashMap<String, Integer> prizeListOnline = new HashMap<>(MAX_PLAYER);

    public static void showBoard(Player newPlayer) {
        String nick = newPlayer.getName();

        prizeObjective = sb.registerNewObjective(
                "PRIZE",
                "DUMMY",
                MessageBeautify.makeMessageGradation("==현상금 수배자==")
        );
        prizeObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // 최초 접속시: 해당 닉네임의 현상금을 0원으로 초기화
        prizeList.putIfAbsent(nick, 0);

        newPlayer.setScoreboard(sb);
    }

    public static void updateBoard() {
        // TODO: 온라인 유저 중 상위권 10등 갱신하고, 표시하기!

        // 온라인 유저 닉네임 목록 만들기
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        HashSet<String> onlinePlayerNicks = new HashSet<>();
        for (Player player : onlinePlayers) {
            String nick = player.getName();
            onlinePlayerNicks.add(nick);
        }

        // 온라인 유저 현상금 목록 만들기
        prizeListOnline.clear();
        for (String nick : prizeList.keySet()) {
            if (onlinePlayerNicks.contains(nick)) {
                Integer prize = prizeList.getOrDefault(nick, 0);
                prizeListOnline.put(nick, prize);
            }
        }

        // 온라인 유저 중 현상금 기준으로 내림차순 정렬하기
        List<Map.Entry<String, Integer>> prizeListOnlineSorted = new ArrayList<>(prizeListOnline.entrySet());
        prizeListOnlineSorted.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // 스코어보드 삭제하고 다시 만들기
        prizeObjective.unregister();
        prizeObjective = sb.registerNewObjective(
                "PRIZE",
                "DUMMY",
                MessageBeautify.makeMessageGradation("==현상금 수배자==") + ChatColor.GOLD
        );
        prizeObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // 온라인 유저 중 상위권 10등까지만 스코어보드에 추가하기
        int count = 0;
        for (Map.Entry<String, Integer> e : prizeListOnlineSorted) {
            String nick = e.getKey();
            Integer newPrize = e.getValue();

            Score s = prizeObjective.getScore(
                    ChatColor.BOLD.toString() + ChatColor.RED + nick +
                            ChatColor.RESET.toString() + ChatColor.GOLD + " : "
            );
            s.setScore(newPrize);

            if (++count >= 10) break; // 11번째부터 반복문 종료
        }

        // 온라인 유저에게 새로운 스코어보드 표시하기
        for (Player player : onlinePlayers) {
            player.setScoreboard(sb);
        }
    }

    public static void addPrize(Player killer, int value) {
        String nick = killer.getName();

        // 해당 닉네임의 현상금 불러오기
        int prize = prizeList.getOrDefault(nick, 0);

        // 해당 닉네임의 현상금 추가하기
        int newPrize = prize + value;
        prizeList.put(nick, newPrize);

        // 스코어보드 갱신하기
        updateBoard();
    }
}
