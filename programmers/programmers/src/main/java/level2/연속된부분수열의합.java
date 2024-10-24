package programmers.programmers.src.main.java.level2;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 2단계 연속된 부분수열의 합
public class 연속된부분수열의합 {
    static Map<Integer, Integer> map = new HashMap<>();
    static int MIN = Integer.MAX_VALUE;

    public int[] solution(int[] sequence, int k) {

        int[] answer = new int[2];
        int j = sequence.length - 1;
        int i = 0;

        while (i != j) {
            func(i++, j--, sequence, k);
        }
        // 같아지는 순간이 옴
        j = sequence.length / 2;
        i = 0;
        while (i != j) {
            func(i++, j--, sequence, k);
        }

        i = sequence.length / 2;
        j = sequence.length - 1;

        while (i != j) {
            func(i++, j--, sequence, k);
        }


        for (Integer value : map.values()) {
            MIN = Math.min(value, MIN);
        }

        // 가장 작은 i값 찾기
        int minKey = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            minKey = Math.min(key, minKey);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == minKey) {
                answer[0] = entry.getKey();
                answer[1] = entry.getKey() + entry.getValue();
            }

        }

        return answer;


    }

    public static void func(int i, int j, int[] sequence, int k) {

        int sum = 0;
        for (int number = i; number <= j; number++) {
            sum += sequence[number];
        }
        // sum이 k보다 크다면 혹은 작다면 포인터를 조정한다는 아이디어?

        if (sum == k) {
            // Map Key에 시작점 i 저장, j-i 차 저장
            map.put(i, j - i);

        }

    }


}


class 연속된부분수열의합Re {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (j < sequence.length) {

            sum+=sequence[j];

            while (sum > k && i <= j) {
                sum -= sequence[i];
                i++;
            }

            if (sum == k) {
                int currentLength = j - i + 1;
                if (min > currentLength) {
                    min = currentLength;
                    answer[0] = i;
                    answer[1] = j;
                }
            }

            j++;

        }


        return answer;

    }
}