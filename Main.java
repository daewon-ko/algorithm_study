//import java.util.*;
//import java.io.*;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//    }
//
//
//
//}
//class Solution {
////    class Solution {
//        public int[] solution(int[] array, int[][] commands) {
//            int[] answer = {};
//            int [] converter = {};
//            int i,j,k = 0;
//
//            for(int m = 0; m<commands.length; m++){
//                int num = 0;
//                i = commands[m][0]-1;
//                j = commands[m][1]-1;
//                k = commands[m][2]-1;
//
//
//                converter=Arrays.copyOfRange(array,i,j);
//
//                Arrays.sort(converter);
//                num = converter[k];
//                answer[m] = num;
//
//            }
//
//            return answer;
//        }
//
//    }
//}