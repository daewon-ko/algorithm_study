package boj;

import java.io.*;
import java.util.*;

//boj 13565 침투
public class boj13565 {
    static int n, m;
    static final int MAX = 1000 + 10;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean answer;

    public static void dfs(int y, int x) {

        if (y == m) {
            answer = true;
            return;
        }


        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (graph[ny][nx] && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= m; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                // 0 -> true, 1 -> false로 역으로 초기화
                // 즉, 전류가 잘 통하는 흰색은 true, 안 통하는 검은색은 false로 변경
                graph[i][j] = line.charAt(j - 1) == '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            if (graph[1][i]) {
                dfs(1, i);
            }
        }

        if (answer) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
        br.close();


    }

}
