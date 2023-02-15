import javax.lang.model.type.IntersectionType;
import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> graph[];
    static boolean[] visited;
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

//

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if (!visited[i]) {
                BFS(i);
            }
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, answer[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxValue) {
                System.out.print(i + " ");
            }
        }


    }

    static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Node);
        visited[Node] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : graph[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    queue.offer(i);
                }
            }
        }

    }
}