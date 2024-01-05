package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 명예의전당 {
    /**
     * 비교대상의 문제 어떻게 처리해야할까?
     * 이전 인덱스와 현재 인덱스를 비교하는게 아니라,
     * Full Scan 하듯이 해야하는데?
     * @param k
     * @param score
     * @return
     */
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> hallOfFame = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            hallOfFame.add(score[i]);
            if (i >= k) {
                hallOfFame.remove(Collections.min(hallOfFame));
            }
            answer[i] = Collections.min(hallOfFame);
        }
        return answer;

//        int[] hallOfFame = new int[k];
//        for (int i = 0; i < score.length; i++) {
//            int compareValue = score[i];
//            if (k >= i+1) {
//                for (int j = 0; j < i; j++) {
//                    int minResult = Math.min(compareValue, score[j]);
//                    answer[i] = minResult;
//                    hallOfFame[i] = score[i];
//                }
//            } else {
//                for (int j = 0; j < k; j++) {
//                    int minResult = Math.min(compareValue, hallOfFame[j]);
//                    answer[i] = minResult;
//                }
//            }
//
//        }
//
//        return answer;
    }
}
