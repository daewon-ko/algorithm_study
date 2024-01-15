package level1;

import java.util.HashMap;
import java.util.Map;

public class 푸드파이트대회 {
    /**
     * 중요한 문제의 조건이라고 생각되는 것
     * -> 먹는 음식의 종류와 양이 같아야한다.
     * <p>
     * [1,3,4,6]
     * 0번 1개(가운데 값), 1번 3개, 2번 4개, 3번 6개
     * -> 홀 수개면 무조건 남는다.
     * <p>
     * 중앙에는 물을배치하므로 0을 기준으로 대칭된다.
     * 배열의 인덱스를 2로 나눈 나머지의 몫의 개수 :
     *
     * @param food
     * @return
     */
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int index;
        int count;

        for (index = 1; index < food.length; index++) {
            count = food[index] / 2;
            for (int j = 0; j < count; j++) {
                sb.append(index);
            }
        }


        StringBuilder reversedBuilder = sb.reverse();
        sb.append("0");
        sb.append(reversedBuilder);

//        for (index = food.length - 1; index >= 1; index--) {
//            count = food[index] / 2;
//            for (int j = 0; j < count; j++) {
//                sb.append(index);
//            }
//        }


        return sb.toString();
    }

}
