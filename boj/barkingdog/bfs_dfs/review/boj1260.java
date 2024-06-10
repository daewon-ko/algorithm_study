package boj.barkingdog.bfs_dfs.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1260 {
    static int n, m, v;


    // Collections.sort 이용을 위해 List배열을 이용하는게 적절하지 않을까?
    // 문제의 조건 상 방문 정점이 여러 개일 경우에 정점 번호가 작은 것부터 방문하라고 했으므로?
    static List<Integer>[] graph;
    //    static int[][] graph;
    static boolean[] visited;
    static final int MAX = 1000 + 10;
    static int[] answer;
    static int order;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[y].add(x);
            graph[x].add(y);
//            graph[y][x] = 1;
//            graph[x][y] = 1;
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }


        order = 1;

        dfs(v);

        System.out.println();

        // bfs용 재초기화

        visited = new boolean[MAX];
        bfs(v);




    }

    public static void dfs(int index) {
        visited[index] = true;
        System.out.printf(index+" ");


        for (int i = 0; i < graph[index].size(); i++) {
            int nextNode = graph[index].get(i);
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }

    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;
        System.out.printf(index + " ");

        while (!queue.isEmpty()) {
            int pollNode = queue.poll();
            for (int i = 0; i < graph[pollNode].size(); i++) {
                int next = graph[pollNode].get(i);
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    System.out.printf(next + " ");
                }
            }

        }

    }
}
