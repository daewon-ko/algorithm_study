package boj.barkingdog.bfs_dfs;

//백준2606번 바이러스

import java.io.*;
import java.util.*;

/**
 * 7대 -> 노드를 의미
 * 연결 -> 엣지
 * <p>
 * List로 관리?
 * List<Integer> list =
 */
public class boj2606 {

    static int n;
    static int m;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    public static void dfs(int index) {
        visited[index] = true;
        answer++;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[index][i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        int x, y;
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

//        dfs(1);
        bfs(1);
        bw.write(String.valueOf(answer -1));

        bw.close();
        br.close();
    }

    public static void bfs(int index) {

        visited[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        answer++;


        while (!queue.isEmpty()) {
            //poll과 index는 같은 의미?
            Integer poll = queue.poll();
            for (int i = 1; i <= n; i++) {

                if (!visited[i] && graph[poll][i]) {
                    queue.offer(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }

    }

}
