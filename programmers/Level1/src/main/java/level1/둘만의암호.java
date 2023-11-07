package level1;

import java.util.LinkedList;
import java.util.Queue;

public class 둘만의암호 {
    class Solution {
        public String solution(String s, String skip, int index) {


            String answer = "";

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (int j = 0; j < index; j++) {
                    c += 1;
                    if (c > 'z') {
                        c -= 26;
                    }
                    if (skip.contains(String.valueOf(c))) {
                        j--;
                    }
                }
                answer += c;
            }

            return answer;

        }
    }

    class Solution2 {
        public String solution(String s, String skip, int index) {
            StringBuilder sb = new StringBuilder();

            for (char letter : s.toCharArray()) {
                char temp = letter;
                int idx = 0;

                while (idx < index) {
                    temp = temp == 'z' ? 'a' : (char) (temp + 1);
                    if (!skip.contains(String.valueOf(temp))) {
                        idx++;
                    }
                }
                sb.append(temp);
            }

            return sb.toString();


        }
    }
}
