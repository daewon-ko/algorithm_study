package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//boj 그림

/**
 * n : 세로 , m : 가로
 * max : 500 +10;
 * 2차원 배열
 * <p>
 * static int cnt -> dfs돌때마다 초기화 필요.
 * 그림의 넓이란 결국 1의 개수이다.
 */
public class boj1926 {
    static int n, m;
    static final int MAX = 500 + 10;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int area;
    static int cnt;

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        area++;

        for (int k = 0; k < 4; k++) {
            int newY = y + dy[k];
            int newX = x + dx[k];

            if (isRange(newY, newX) && !visited[newY][newX] && graph[newY][newX] == 1) {
                dfs(newY, newX);
            }
        }


    }

    public static boolean isRange(int y, int x) {
        return x >= 1 && x <= m && y >= 1 && y <= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                area = 0;
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                    max = Math.max(area, max);
                }

            }
        }

        System.out.println(cnt);
        System.out.println(max);

        br.close();


    }
}
