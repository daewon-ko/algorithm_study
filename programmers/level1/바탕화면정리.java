package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < wallpaper.length; i++) {
                char[] charArray = wallpaper[i].toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == '#') {
                        map.put(i, j);
                    }
                }
            }
            // i에 세로, j에 가로가 들어있음. 즉 key값에 세로축 값, value에 가로축 값
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            int lux = Integer.MAX_VALUE; // key의 최솟값
            int luy = Integer.MAX_VALUE; // value의 최솟값
            int rdx = Integer.MIN_VALUE; // key의 최대값
            int rdy = Integer.MIN_VALUE; // value의 최댓값
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                lux = Math.min(lux, key);
                luy = Math.min(luy, value);
                rdx = Math.max(rdx, key);
                rdy = Math.max(rdy, value);
            }
            int[] answer = new int[]{lux, luy, rdx+1, rdy+1};

            return answer;
        }
    }
}
