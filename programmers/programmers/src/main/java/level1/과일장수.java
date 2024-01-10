package level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 과일장수 {
    /**
     * 문제가 생각보다 복잡하다는 생각이 일단 든다.
     *
     * m이라는 변수에 따라서 크기가 m인 배열을 만든다.
     * 가능한 많은 사과를 판다는 것의 의미?
     * score[]에서 array[m]의 배열을 만드는데,
     * 최대이익은 어떻게 만들 수 있지?
     * @param k 사과의 최고 점수
     * @param m score 배열을 몇 개의 element로 쪼갤지를 결정하는 변수
     * @param score 사과의 점수를 담고있다. 7부터 1,000,000까지 가능하므로 시간복잡도에서 중요한 값같다.
     * @return
     */
    public int solution1(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for (int i = score.length; i >= m; i -= m) {
            answer += m * score[i-m];
        }
        return answer;
    }

//    public int solution2(int k, int m, int[] score) {
//        int answer = 0;
//        List<Integer> collect = Arrays.stream(score).boxed().sorted().collect(Collectors.toList());
//        for (int i = collect.size(); i >0; i--) {
//            if ((i-1) % m == 0) {
//                answer += m * collect.get(i);
//            }
//        }
//        return answer;
//    }
}
