package programmers.highScoreKit;

import java.util.HashMap;

// 프로그래머스 폰켓몬 문제
public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int type : nums) {
                hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            }

            return hashMap.size();
        }
    }
}
