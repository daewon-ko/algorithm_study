package programmers.highScoreKit;
import java.util.*;
import java.io.*;
// 고득점 키트 - 정렬 - k번쨰 수
public class Kth_Number {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int i,j,k = 0;

            for(int m = 0; m<commands.length; m++){

                int num = 0;
                i = commands[m][0]-1;
                j = commands[m][1]-1;
                k = commands[m][2]-1;
                int len = j-i +1;
                int [] converter = new int[len];


                // for(int z= 0; z<len; z++){
                //     converter[z] = array[i+z];
                // }

//                converter=Arrays.copyOfRange(array[m],i,j);


                Arrays.sort(converter);
                System.out.println(k);
                num = converter[k];
                answer[m] = num;

            }

            return answer;
        }

    }

}
