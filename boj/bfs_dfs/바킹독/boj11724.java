package boj.bfs_dfs.바킹독;

import java.util.*;
import java.io.*;

// 백준 연결요소의 개수
public class boj11724 {
    static final int MAX = 1000 + 10;
    static int n, m;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    public static void dfs(int index) {
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[index][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 1; i <= m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }


        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));


        bw.close();
        br.close();

    }
}
