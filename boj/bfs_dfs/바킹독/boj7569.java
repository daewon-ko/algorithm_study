package boj.bfs_dfs.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 토마토
public class boj7569 {

    static int dz[] = {1, -1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 0, -1, 0, 1};
    static int dx[] = {0, 0, 1, 0, -1, 0};
    static int result = 0;

    static final int MAX = 100 + 10;
    // m : 가로(y좌표), n : 세로(x좌표), h(z좌표)
    static int m, n, h;

    static int [][][] graph;
    static boolean [][][] visited;

    static Queue<Tomato> queue = new LinkedList<>();

    static class Tomato {
        int z;
        int y;
        int x;

        public Tomato(final int z, final int y, final int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX][MAX];
        visited = new boolean[MAX][MAX][MAX];



        // graph 초기화
        for (int i = 1; i <= h; i++) {  // 높이
            for (int j = 1; j <= m; j++) {  // 행
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {  // 열
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }



        bfs();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[i][j][k] == 0) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);




    }

    public static void bfs() {


        while (!queue.isEmpty()) {
            Tomato poll = queue.poll();
            int pollZ = poll.z;
            int pollY = poll.y;
            int pollX = poll.x;

            for (int i = 0; i < 6; i++) {
                int newZ = pollZ + dz[i];
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];

                if (isRange(newZ, newY, newX) && !visited[newZ][newY][newX] && graph[newZ][newY][newX] == 0) {
                    queue.offer(new Tomato(newZ, newY, newX));
                    visited[newZ][newY][newX] = true;
                    graph[newZ][newY][newX] = graph[pollZ][pollY][pollX] + 1;
                    result = graph[newZ][newY][newX];
               }
            }
        }


    }

    public static boolean isRange(int z, int y, int x) {
        return z >= 1 && z < MAX && y >= 1 && y < MAX && x >= 1 && x < MAX;
    }
}
