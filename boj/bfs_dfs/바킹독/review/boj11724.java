package boj.bfs_dfs.바킹독.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724 {
    static final int MAX = 1000 + 10;
    static int[][] graph;
    static boolean[] visited;
    static int answer = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX];
        visited = new boolean[MAX];

        // graph 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }




        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
//                dfs(i);
//                answer++;
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);


    }

    public static void dfs(int index) {
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int index) {
        visited[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[poll][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
