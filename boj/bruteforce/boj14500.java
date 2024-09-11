package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
    static int[][] graph;
    static boolean[][] visited;
    static int n, m;
    static final int MAX = 500 + 10;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 1, graph[i][j]);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

//            if (!inRange(newY, newX)) {
//                continue;
//            }
//
//            if (visited[newY][newX]) continue;
//
//
//            if (depth == 2) {
//                visited[newY][newX] = true;
//                dfs(y, x, depth + 1, sum + graph[newY][newX]);
//                visited[newY][newX] = false;
//            }
//
//            visited[newY][newX] = true;
//            dfs(newY, newX, depth + 1, sum + graph[newY][newX]);
//            visited[newY][newX] = false;


            if (inRange(newY, newX) && !visited[newY][newX]) {
                if (depth == 2) {
                    visited[newY][newX] = true;
                    dfs(y, x, depth + 1, sum + graph[newY][newX]);
                    visited[newY][newX] = false;
                }
                    visited[newY][newX] = true;
                    dfs(newY, newX, depth + 1, sum + graph[newY][newX]);
                    visited[newY][newX] = false;


            }
        }

    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= m;
    }
}
