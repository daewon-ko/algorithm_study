package do_it_algorithm;

// 백준 효율적으로 해킹하기문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class Q47_boj1325 {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            BFS(i);
        }
        int maxVal = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxVal) {
                System.out.print(i + " ");
            }
        }

    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int temp : graph[now_node]){
                if(!visited[temp]){
                    visited[temp] = true;
                    answer[temp]++;
                    queue.offer(temp);

                }
            }
        }
    }
}
