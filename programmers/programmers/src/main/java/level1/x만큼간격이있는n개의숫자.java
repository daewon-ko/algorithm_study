package programmers.programmers.src.main.java.level1;

public class x만큼간격이있는n개의숫자 {
        public long[] solution(int x, int n) {



            long[] answer = new long[n];
            long convert_x = x;
            long first = x;


            for(int i=0; i<n; i++){
                answer[i] = convert_x;
                convert_x+=first;

            }
            return answer;
        }
}
