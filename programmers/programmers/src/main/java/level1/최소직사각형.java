package level1;

public class 최소직사각형 {
    public static void main(String[] args) {
        int [][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        최소직사각형.solution(sizes);
    }
    // import java.util.*;

        public static int solution(int[][] sizes) {
            int answer = 0;

            int n = sizes.length;   // 열의 길이

            int max_total = 0;
            int min_total = 0;

            for(int i=0; i<n; i++){

                int width = sizes[i][0];
                int high = sizes[i][1];
                int max = Math.max(width, high);
                int min = Math.min(width, high);

                // if(max != width){
                //     int temp = width;
                //     width = high;
                //     high = temp;
                // }


                max_total=Math.max(max_total, max);
                min_total= Math.max(min_total, min);
            }

            answer = (min_total * max_total);

            return answer;
        }
    }
