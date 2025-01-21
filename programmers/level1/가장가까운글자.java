package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운글자 {
    public int[] solution(String s) {
        /**
         * 1. 문자열 s를 탐색한다.
         * s를 탐색하며 최초의 문자일 경우 -1을 저장한다
         * 최초의 문자가 아닐 경우 같은 문자가 위치한 index에서 현재 index와
         * 가까운 위치를 저장한다.
         *
         */

        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                answer[i] = -1;
            }
            else{
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        return answer;

        /**
         * 하단은 1차적으로 생각했던 것
         */
//        Map<Character, Integer> charStore = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (s.charAt(j) == s.charAt(i)) {
//                    charStore.put(s.charAt(j), j);
//                }
//            }
//        }
//
//        for (Map.Entry<Character, Integer> characterIntegerEntry : charStore.entrySet()) {
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == characterIntegerEntry.getKey()) {
//                    answer[i] = characterIntegerEntry.getValue();
//                }
//            }
//            ;
//        }
//        return answer;
    }

    /**
     * 참고풀이
     * @param s
     * @return
     */
    public int[] solution2(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            answer[i] = i - map.getOrDefault(s.charAt(i), i + 1);
            map.put(s.charAt(i), i);
        }
        return answer;
    }
}
