package boj.bfs_dfs;

import java.io.*;
import java.util.*;
//DFS와 BFS

/**
 * n의 MAX값이 1000이므로 1000 x 1000 -> 백만이므로 1억 미만이기에
 * 직관적인 2차원배열로 graph를 생성
 */
public class boj1260 {


    static final int MAX = 1000+10;
    static int n,m,v;
    static boolean [] visited;
    static boolean [][] graph;
    static ArrayList<Integer> queue;

    public static void dfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[index][i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        visited = new boolean[MAX];
        queue = new ArrayList<>();

        queue.add(v);
        visited[v]= true;

        while (!queue.isEmpty()) {
            int index = queue.remove(0);
            System.out.print(index+" ");
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[index][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(v);
        System.out.println();

        bfs();




    }
}

