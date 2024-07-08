package boj.bfs_dfs.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 나이트

/**
 * 1. 8개의 좌표를 dx, dy로 표현한다. 2차원좌표이므로 dx,dy테크닉과 마찬가지로 1차원배열 2개가 필요하다.
 * 2. 최솟값이므로 bfs로 접근한다.
 * 3. 좌표쌍의 범위는 0<= <= l-1까지이다.
 * 4. 각 테스트케이스마다 결과값을 출력해야한다.
 *
 * 범위 검증 -> Queue에 넣기때문에 MAX 값은 의미가 없다.
 * (왜냐하면 이차원 배열의 그래프를 형성하지 않기때문에)
 *
 * -> 따라서 MAX값으로 범위를 설정하면 반드시 오류가 발생한다.
 */
public class boj7562 {
    static final int MAX = 300 + 10;
    static int n, l;
//    static boolean[][] visited;

    // a,b-> 나이트가 현재있는 칸, c,d -> 나이트가 이동하고자 하는 칸이라고 임의로 가정한다.
    static int a, b, c, d;

    // 나이트가 현재좌표에서 이동할수 있는 8가지의 경우의 수 정의

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
//    static


    static class Pair {
        int y;
        int x;
        int cnt;

        public Pair(final int y, final int x, final int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            // 현재좌표와 목표좌표를 Queue에 추가한다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) + 1;
            b = Integer.parseInt(st.nextToken()) + 1;
            // 좌표의 시작점을 1부터 l까지로 정의하기 위해 1을 더해준다.

            st = new StringTokenizer(br.readLine());
            // 좌표의 시작점을 1부터 l까지로 정의하기 위해 1을 더해준다.
            c = Integer.parseInt(st.nextToken()) + 1;
            d = Integer.parseInt(st.nextToken()) + 1;

            System.out.println(bfs(a, b));


        }

        br.close();


    }

    public static int bfs(int y, int x) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(y, x, 0));

        boolean[][] visited = new boolean[MAX][MAX];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int pollY = poll.y;
            int pollX = poll.x;
            int pollCnt = poll.cnt;

            if (pollY == c && pollX == d) {
                return pollCnt;
            }


            for (int i = 0; i < 8; i++) {
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];

                if (isRange(newY, newX) && !visited[newY][newX]) {
                    queue.offer(new Pair(newY, newX, pollCnt + 1));
                    visited[newY][newX] = true;
                }
            }
        }

        // bfs를 실행했는데, 목표좌표에 도달하지 못한다.
        // 근데 애초에 문제에서 가정하지 않는 상황을 아래와 같이 정의할 필요가 있을까?
        return -1;

    }

    public static boolean isRange(int y, int x) {
        return y >= 1 && y <= l && x >= 1 && x <=l;
    }
}
