package boj.barkingdog.재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 종이의 개수
 * 1. 종료조건 -> 주어진 그래프가 모두 같은 수일때?
 * 해당 그래프에서 재귀적으로 9개가 되도록 종이를 나눈다의 의미 -> 수식으로 어떻게 표현해줄 수 있을까?
 * -> 3등분 x 3등분한다.(가로 세로)
 * 그래프의 전체 길이(예시에서는 9)의 3분의 1크기씩 재귀적으로 들어가서 그래프를 탐색한다.
 * <p>
 * 2. n조건에서 그래프의 길이에서 9만큼 나눈 새로운 크기의 그래프를 만든다?
 * -> 그렇다면, 그래프에 들어있는 값들은 어떻게 또 초기화 하는가?
 */
public class boj1780 {
    static int minusOneCnt = 0;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 함수의 매개변수를 무엇으로 둘 것인가?
         * 애초에 graph를 static으로 선언했는데, 매개변수에 graph를 넣는다면 의미가 없다.
         */
        recursive(1, 1, n);
        System.out.println(minusOneCnt);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    public static void recursive(int y, int x, int graphLength) {

        // 특정 종료조건
        if (validatePaper(y, x, graphLength)) {
            if (graph[y][x] == -1) {
                minusOneCnt++;
//                return;
            } else if (graph[y][x] == 0) {
                zeroCnt++;
//                return;
            } else if (graph[y][x] == 1) {
                oneCnt++;
//                return;
            }
            return;
        }
        int newGraphLength = graphLength / 3;

        recursive(y, x, newGraphLength);
        recursive(y, x + newGraphLength, newGraphLength);
        recursive(y, x + 2 * newGraphLength, newGraphLength);

        recursive(y + newGraphLength, x, newGraphLength);
        recursive(y + newGraphLength, x + newGraphLength, newGraphLength);
        recursive(y + newGraphLength, x + 2 * newGraphLength, newGraphLength);

        recursive(y + 2 * newGraphLength, x, newGraphLength);
        recursive(y + 2 * newGraphLength, x + newGraphLength, newGraphLength);
        recursive(y + 2 * newGraphLength, x + 2 * newGraphLength, newGraphLength);
    }

    public static boolean validatePaper(int y, int x, int graphLength) {
        int standard = graph[y][x];

        for (int i = y; i < y + graphLength; i++) {
            for (int j = x; j < x + graphLength; j++) {
                if (standard != graph[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }
}
