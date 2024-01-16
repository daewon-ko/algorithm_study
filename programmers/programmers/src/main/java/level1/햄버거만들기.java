package level1;

import java.util.ArrayList;
import java.util.List;

public class 햄버거만들기 {
    /**
     * 1(빵) - 2(야채) - 3(고기) - 1(빵)
     * 위와 같은 순서 만족하면 1개의 햄버거가 만들어진다.
     * <p>
     * 외부에서 주어지는 ingredient 배열에서 위 순서의 햄버거를
     * 몇 개를 만들 수 있는 지를 작성하는 알고리즘 문제
     * <p>
     * 1<= ingredient<=1,000,000이므로
     * 시간복잡도에서 영향이 있을수 있겠다.
     * <p>
     * 정렬한다 -> 배열의 순서가 중요하므로 하면 안될듯?
     * <p>
     * 햄버거 개수 : int count;
     * 자료구조 : if(
     * 1-2개, 2,3 -1개가 만족하면 햄버거 1개
     *
     * @param ingredient
     * @return
     */
    public int solution(int[] ingredient) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : ingredient) {
            list.add(i);
            while (list.size() >= 4) {
                if (!(list.get(list.size() - 4) == 1
                        && list.get(list.size() - 3) == 2
                        && list.get(list.size() - 2) == 3
                        && list.get(list.size() - 1) == 1)) {
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    list.remove(list.size() - 1);
                }
                count++;
            }
        }
        return count;
    }
}
