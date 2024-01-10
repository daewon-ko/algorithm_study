package level1;

import java.util.HashMap;
import java.util.Map;

public class 문자열나누기 {
    public int solution(String s) {
        /**
         * 문자열과 문자열의 횟수를 count하는 자료구조
         * -> MAP
         * Character, Integer 형태로 저장하는데,
         * Integer 숫자가 같을 때 문자열 s를 쪼갠다.
         *
         * 해당 숫자가 같은 것을 조건으로 분기한다.
         * -> HOW?
         *
         */
        Map<Character, Integer> map = new HashMap<>();


        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(0);
            map.put(s.charAt(i), count++);
            if (map.get(startChar) == map.get(s.charAt(i))) {

            }
            count = 0;
        }

        int answer = 0;

        return answer;
    }
}
