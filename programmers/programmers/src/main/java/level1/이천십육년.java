package programmers.programmers.src.main.java.level1;

public class 이천십육년 {
        static int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

        static String [] day = {"FRI", "SAT", "SUN","MON","TUE","WED","THU"};
        public String solution(int a, int b) {

            int answer = 0;

            for(int i=0; i<a-1; i++){
                answer+=month[i];
            }

            answer+=b-1;

            return day[answer%7];

        }
}
