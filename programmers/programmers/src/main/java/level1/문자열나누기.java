package programmers.programmers.src.main.java.level1;

import java.util.HashMap;
import java.util.Map;

public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int sameCount = 1;
        int diffCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if(first == s.charAt(i)) {
                sameCount++;
            }else{
                diffCount++;
            }

            if(sameCount == diffCount) {
                answer++;
                if(i+1<s.length()){
                    first = s.charAt(i);
                }
                sameCount = 0;
                diffCount = 0;
            }
        }

        if (sameCount != 0 || diffCount != 0) {
            answer++;
        }

        return answer;
    }
}
