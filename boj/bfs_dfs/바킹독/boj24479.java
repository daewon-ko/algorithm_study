package boj.bfs_dfs.바킹독;

import java.util.*;
import java.io.*;
public class boj24479 {

    final static int MAX = 10000000 + 10;
    static ArrayList<Integer> [] graph;
    static int n,m,r;
    static int [] answer;
    static int order;
    static boolean [] visited;

    private static void dfs(int index) {
        visited[index] = true;
        answer[index] = order;
        order++;

        for (int i = 0; i < graph[index].size(); i++) {
            dfs(graph[index].get(i));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();


    }
}
