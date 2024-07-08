
package boj.bfs_dfs.바킹독.review;

import java.util.*;
import java.io.*;

public class boj24480 {
    static int n, m, r;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int order;
    static int[] answer;
    static final int MAX = 100000 + 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];

        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {

            System.out.println(answer[i]);
//            bw.write(answer[i]);
//            bw.newLine();
        }
        bw.close();
        br.close();

    }

    public static void dfs(int index) {
        visited[index] = true;
        answer[index] = order;
        order ++;

        for (int i = 0; i < graph[index].size(); i++) {
            int nextNode = graph[index].get(i);

            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
