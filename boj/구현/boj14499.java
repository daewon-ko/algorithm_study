package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 주사위 굴리기
public class boj14499 {
    static int n, m;
    // 동 , 서, 북 , 남
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dice;
    static int y, x;
    static int k;
    static int[][] graph;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(st.nextToken());
            solve(direction - 1);
        }

        System.out.println(sb);

    }

    public static void solve(int direction) {
        int newY = y + dy[direction];
        int newX = x + dx[direction];

        if (!inRange(newY, newX)) {
            return;
        }

        int temp = dice[5];

        switch (direction) {

            // 동
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;
                break;
            // 서
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;

                break;
            // 북
            case 2:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;
                break;
            default:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;

        }
        sb.append(dice[0]).append("\n");
        x = newX;
        y = newY;

        if (graph[y][x] == 0) {
            graph[y][x] = dice[5];
        }
        else {
            dice[5] = graph[y][x];
            graph[y][x] = 0;
        }

    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
