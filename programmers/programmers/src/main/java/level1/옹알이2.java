package programmers.programmers.src.main.java.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 옹알이2 {
    /**
     * aya, ye, woo, ma
     * 각 1번씩 사용해서
     * babbling[i]와 equals가 같는 것의 개수(count)를 구해야한다.
     *
     * int count= 0;
     * StringBuilder? -> append() 메서드 사용?
     * @param babbling
     * @return
     */

    //TODO : replace 메서드 생각조차 못했다. -> 실력부족
    // replace와 replaceALL 메서드의 차이 학습하기
    public int solution(String[] babbling) {

//        String[] speak = new String[]{"aya","ye", "woo", "ma"};
        LinkedList<String> speak = new LinkedList<>();
        speak.add("aya");
        speak.add("ye");
        speak.add("woo");
        speak.add("ma");
        int count = 0;
        for (String word : babbling) {
            StringBuilder sb = new StringBuilder();
            //sb와 word가 같지 않으면 하단의 while을 반복한다.
            while (!word.equals(sb)) {
                for (int j = 0; j < speak.size(); j++) {
                    sb.append(speak.pollFirst());
                }

            }
            count++;
        }
        int answer = 0;
        return answer;
    }

}
