package programmers.programmers.src.main.java.level1;


import java.util.Arrays;
import java.util.stream.IntStream;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1_index = 0;
        int card2_index = 0;
        String answer = "YES";

        for(String word : goal){
            if (card1_index < cards1.length && word.equals(cards1[card1_index])) {
                card1_index++;
            } else if (card2_index < cards2.length && word.equals(cards2[card2_index])) {
                card2_index++;
            }else{
                answer = "NO";
            }
        }

        return answer;


    }

}
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {


            int count =0;
            for (int i = count; count< goal.length; count++) {
                for (int j = 0; j< cards1.length; j++) {
                    if (goal[i].equals(cards1[j])) {
                        goal[i] = "";
                        cards1[j] = "";
                    }
                }
                for (int j = 0; j < cards2.length; j++) {
                    if(goal[i].equals("123"));
                }
            }
            for (int i = 0; i < goal.length; i++) {
                for (String s : cards2) {
                    if (goal[i].equals(s)) {
                        goal[i] = "";
                    }
                }
            }



            String answer = "";
            boolean flag = true;

            for (String s : goal) {
                if (!s.equals("")) {
                    flag= false;
                }
            }

            if (flag) {
                answer = "Yes";
                return answer;
            }
            answer = "No";
            return answer;
        }
    }
