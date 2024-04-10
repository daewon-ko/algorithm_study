package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 같은 부류 찾기
public class boj16173 {
    static int n;
    static final int MAX = 3 + 100 + 10;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        graph = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        if (visited[n][n]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }


    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        if (y == n && x == n) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            int newY = y + dy[i] * graph[y][x];
            int newX = x + dx[i] * graph[y][x];
            if (!visited[newY][newX] && newY <= MAX && newX <= MAX) {
                dfs(newY, newX);
            }
        }

    }
}
