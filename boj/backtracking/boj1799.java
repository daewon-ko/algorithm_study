package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비숍
 */
public class boj1799 {
    static int n;
    static final int MAX = 10 + 1;
    static int[][] arr;

    static boolean[][] visited;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int cnt = 0;
    static int zero_land = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);


    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int vector_cnt = 1;

            int newY = vector_cnt * dy[i] + y;
            int newX = vector_cnt * dx[i] + x;

            while (inRange(newY, newX) && !visited[newY][newX] && arr[newY][newX] ==1) {
                dfs(newY, newX);
                cnt++;
            }


        }
    }

    public static boolean inRange(int newY, int newX) {
        return newY >= 1 && newY <= n && newX >= 1 && newX <= n;
    }
}

