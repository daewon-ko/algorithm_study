package level1;

public class 덧칠하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int m = 4;
        int[] section = {1,3};
        System.out.println(solution.solution(n, m, section));

    }

    /**
     * 1. n: 벽 전체의 길이 . 세로, 가로 구분은?
     * 2. m : 롤러의 길이
     * 3. 구역은 n개(1m짜리 구역이 n개 존재)
     */


    static class Solution {
        public int solution(int n, int m, int[] section) {
            int formerElement = 0, latterElement = 0;
            for (int i = 0; i < section.length; i++) {
                if (i == 0) {
                    formerElement = section[0];
                } else if (i == section.length - 1) {
                    latterElement = section[section.length - 1];
                }
            }
            int holeSize = (latterElement - formerElement + 1);

            if (holeSize > m && holeSize % m == 0) {
                return holeSize / m;
            } else if (holeSize > m && holeSize % m != 0) {
                return (int) (holeSize / m) + 1;
            } else if (holeSize == m) {
                return 1;
            }
            return 0;

        }
    }
}
