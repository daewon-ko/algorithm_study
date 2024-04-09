package boj;

import java.io.*;
import java.util.StringTokenizer;

// 바닥 장식


// 바닥 장식
public class boj1388 {
    static char[][] map;
    static boolean[][] visited;
    static final int MAX = 50 + 10;
    static int n, m;

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        if (map[y][x] == '-' && map[y][x + 1] == '-') {
            dfs(y, x + 1);
        }
        if (map[y][x] == '|' && map[y + 1][x] == '|') {
            dfs(y + 1, x);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }

            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();


    }
}



