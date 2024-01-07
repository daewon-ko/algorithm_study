package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class 기사단원의무기 {
    public static void main(String[] args) {
        기사단원의무기 a1 = new 기사단원의무기();
        a1.solution(5, 3, 2);
    }
    /**
     * 약수 개수를 구한다.
     * 어떻게?
     * 4 -> 1, 2, 4
     * 어떤 매커니즘으로 구현할 수 있지?
     * <p>
     * number에 해당하는 만큼 반복문으로 '배열'에 숫자를 넣는다.
     * 배열이 아니라 다른 자료구조를 상상해봐도 좋다.
     * why? -> 배열은 기본적으로 정적이고 딱딱하다.
     * <p>
     * Map같은 자료구조를 상상해보자, 각각의 숫자(key), value(약수의 개수)
     * <p>
     * 약수의 개수는 어떻게 구하지?
     * 자기자신보다 작은 수 중에서, 나누어 떨어지는 수
     *
     * @param number
     * @param limit
     * @param power
     * @return
     */
    public int solution(int number, int limit, int power) {

        int answer = getMadeDivisor(number, power, limit);

        return answer;

    }

    private int getMadeDivisor(final int number, final int power, final int limit) {
        int answer = IntStream.rangeClosed(0, number)
                .map(i -> {
                    int cnt = IntStream.rangeClosed(1, (int) Math.sqrt(i))
                            .map(
                                    j -> (j * j == i) ? 1 : (i % j == 0) ? 2 : 0).sum();

                    return cnt > limit ? power : cnt;
                }).sum();
        return answer;

    }
}
