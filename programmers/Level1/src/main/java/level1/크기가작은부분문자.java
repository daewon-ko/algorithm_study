package level1;

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
}
