package boj.barkingdog.bfs_dfs;

// 백준 2206번 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 행렬, 그래프 , 최단거리 -> BFS 이용해야겠다.
 * 0 : 이동 가능 / 1 : 벽 (이동 불가)
 * 이동방향 : 상하좌우(4가지 -> dx,dy 테크닉)
 * <p>
 * 특이한 점
 * 1. 이동경로가 짧아진다면 벽을 부술 수 있다.
 * -> 코드로 어떻게 표현해야하며, 무엇을 기준으로 부술 수 잇다고 할 수 있을까? 가령, 벽을 부술 수 있으면 불가능한 경로는 없는 것 아닌가?
 * -> 한개까지 부수면 가능
 * 2. MAX : 1000 -> 2차원배열이라면 시간복잡도 100만
 * 3. (1,1) , (n,m)은 항상 0
 * 4. 좌표가 1부터 시작한다.
 */
public class boj2206 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static final int MAX = 1000 + 10;
//    static Queue<Pair> queue = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 초기 0으로 시작하고 1이 되면

    static class Pair {
        int y;
        int x;
        int distance;
        int destroyCnt;

        public Pair(final int y, final int x, final int distance, final int destroyCnt) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.destroyCnt = destroyCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
            }
        }


        System.out.println(bfs(1, 1));
        br.close();


    }

    public static int bfs(int y, int x) {
        Queue<Pair> queue = new LinkedList<>();
        // 초기 좌표 역시 1을 카운트 하고 벽을 부슨 cnt를 0으로 초기화한다.
        queue.offer(new Pair(y, x, 1, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int pollY = poll.y;
            int pollX = poll.x;
            int pollDestroyCnt = poll.destroyCnt;
            int pollDistance = poll.distance;
            int DESTROY_WALL_CNT = 0;

            for (int i = 0; i < 4; i++) {
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];

                if (newY == n && newX == m) {
                    return poll.distance + 1;
                }


                // Pair객체가 bfs를 수행할때 상하좌우 확인시에, 이미 벽을 부섰고 graph[newY][newX] ==1이라면 스킵한다.
                if (DESTROY_WALL_CNT == 1 && graph[newY][newX] == 1) {
                    continue;
                }

                // 벽을 부수지 않는 경우
                if (isRange(newY, newX) && graph[newY][newX] == 0 && !visited[newY][newX]) {
                    queue.offer(new Pair(newY, newX, pollDistance + 1, pollDestroyCnt));
                    visited[newY][newX] = true;

                } else if (canMoveAroundWall(newY, newX, pollDestroyCnt, DESTROY_WALL_CNT)) {
                    queue.offer(new Pair(newY, newX, pollDistance + 1, pollDestroyCnt + 1));
                    visited[newY][newX] = true;
//                    graph[newY][newX] = 0;
                }
            }

            DESTROY_WALL_CNT = 0;
        }


        // 도둘하지 않는 경우
        return -1;

    }

    public static boolean isRange(int y, int x) {
        return y >= 1 && y <=n && x >= 1 && x <=m;
    }

    public static boolean canMoveAroundWall(int newY, int newX, int destroyCnt, int DESTROY_WALL_CNT) {
        int result = graph[newY][newX];
        if (destroyCnt == 0 && result == 1) {
            // 자기 좌표에서 벽에 가로막혀있으면 벽을 부수는 것을 수행.
            // 전역변수(static)변수로 벽을 부순 횟수를 설정해준다.
            DESTROY_WALL_CNT++;
            return true;
        }
        return false;
    }
}
