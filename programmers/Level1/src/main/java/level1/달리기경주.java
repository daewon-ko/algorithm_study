package level1;

import java.util.*;
import java.util.stream.IntStream;

public class 달리기경주 {
    private static Map<String, Integer> playerInfo = new HashMap<>();



    public String[] Solution(String [] players, String [] callings) {
        currentRanking(players);

        Arrays.stream(callings).forEach(
                player -> {
                    Integer nowRanked = playerInfo.get(player);
                    String frontPlayer = players[nowRanked - 1];

                    players[nowRanked] = frontPlayer;
                    players[nowRanked - 1] = player;


                    /**
                     * 위와 아래는 동일하다.
                     * HashMap의 구조 상, 동일한 Key값을 다시 넣어도 Value만 업데이트 된다.
                     */
//                    playerInfo.replace(frontPlayer, nowRanked);
//                    playerInfo.replace(player, nowRanked - 1);

                    playerInfo.put(player, nowRanked - 1);
                    playerInfo.put(frontPlayer, nowRanked);
                }
        );
        return players;
    }

    private void currentRanking(String [] players ) {
        IntStream.range(0, players.length).forEach(
                idx ->{
                    playerInfo.put(players[idx], idx);
                }
        );

    }


}
