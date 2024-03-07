package level1;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        /**
         * peek 1 : 1, 2, 3, 4, 5
         * peek 2 : 2, 1, 2, 3, 2, 4, 2, 5  // 8개 단위로 반복
         * peek 3 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
         */
        int[] peek1 = new int[]{1, 2, 3, 4, 5};
        int[] peek2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] peek3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == peek1[i % 5]) {
                p1++;
            }
            if (answers[i] == peek2[i % 8]) {
                p2++;
            }
            if (answers[i] == peek3[i % 10]) {
                p3++;
            }
        }


        int max = Math.max(p1, Math.max(p2, p3));

        // List<Integer> list = List.of(p1, p2, p3);

        List<Integer> list = new ArrayList<>();


        if (max == p1) {
            list.add(1);
        }
        if (max == p2) {
            list.add(2);
        }
        if (max == p3) {
            list.add(3);
        }

        Collections.sort(list);

        int[] result = list.stream().mapToInt(i -> i)
                .toArray();


        return result;
    }
}

