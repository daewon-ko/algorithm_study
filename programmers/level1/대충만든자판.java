package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {

    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < keymap.length; i++) {
                for (int j = 0; j < keymap[i].length(); j++) {
                    char c = keymap[i].charAt(j);
                    if (map.containsKey(c)) {
                        Integer number = map.get(c);
                        map.put(c, Math.min(number, j + 1));
                    } else{
                        map.put(c, j + 1);
                    }

                }
            }

            for (int i = 0; i < targets.length; i++) {
                int cnt =0;
                boolean flag = true;
                String target = targets[i];
                for (Character c : target.toCharArray()) {
                    if (map.containsKey(c)) {
                        cnt += map.get(c);
                    } else {
                        flag = false;
                        break;
                    }
                }
                answer[i] = flag == false ? -1 : cnt;
            }

            return answer;
        }
    }
}
