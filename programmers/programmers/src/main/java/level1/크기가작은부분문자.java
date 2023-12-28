package level1;

import java.util.stream.LongStream;

public class 크기가작은부분문자 {
    class Solution {
        public int solution(String t, String p) {

            int pLengthSize = p.length();
            long pNumber = Long.parseLong(p);
            int cnt =0;

            for (int i = 0; i < t.length(); i++) {
                if (i + pLengthSize <=t.length()) {
                    long tNumber = Long.parseLong(t.substring(i, i+pLengthSize));
                    if (tNumber <=pNumber){
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

    // Stream을 이용한 풀이
    class SolutionByStream{
        public int solution(String t, String p) {
            long targetNumber = Long.parseLong(p);
            int targetNumberLength = p.length();

            return (int) LongStream.range(0L, t.length() - targetNumberLength + 1)
                    .filter(i -> i+targetNumberLength<=t.length())
                    .mapToObj(i -> t.substring((int) i, (int) (i + targetNumberLength)))
                    .mapToLong(Long::parseLong)
                    .filter(number -> number <= targetNumber)
                    .count();
        }
    }
}
