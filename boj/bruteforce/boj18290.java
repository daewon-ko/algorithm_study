package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * nm과 k(1)
 */
public class boj18290 {
    static int n, m, k;
//    static int[] dx = {1, 1, -1, -1};
//    static int[] dy = {1, -1, -1, 1};

    static int[] dy = {1, 1, -1, -1};
    static int[] dx = {1, -1, -1, 1};
    static int[][] arr;
    static boolean[][] visited;

    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j], 1);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(MAX);

    }

    public static void dfs(int y, int x, int sum, int cnt) {

        visited[y][x] = true;

        if (cnt == k) {
            MAX = Math.max(sum, MAX);
        }


        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (inRange(newY, newX) && !visited[newY][newX]) {
                dfs(newY, newX, sum +arr[newY][newX], cnt + 1);
                visited[newY][newX] = false;
            }


        }


    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }


}
