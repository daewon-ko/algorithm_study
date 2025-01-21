package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스 요격시스템
 */
public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(target -> target[1]));

        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);

        int lastNumber = Integer.MIN_VALUE;
        int missileCnt = 0;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= lastNumber) {
                missileCnt++;
                lastNumber = end;
            }
        }
        answer = missileCnt;
        return answer;
    }
}
