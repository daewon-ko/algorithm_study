package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16931 {
    static int n, m;

    static int[][] graph;

    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        answer += 2 * n * m;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkArround(i, j);
            }
        }

        System.out.println(answer);

    }

    public static void checkArround(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (!inRange(newY, newX)) {
                answer += graph[y][x];
            } else if (graph[newY][newX] > 0) {
                if (graph[newY][newX] > graph[y][x]) {
                    answer += graph[newY][newX] - graph[y][x];
                }
            }
        }
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

}


