package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 이분그래프 판별하기 문제
public class Q48_boj1707 {
    private static List<Integer> gragh[];
    private static int[] colors;
    private static final int RED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            gragh = new ArrayList[v + 1];
            colors = new int[v + 1];

            for (int j = 1; j <= v; j++) {
                gragh[j] = new ArrayList<>();
            }

            for (int p = 0; p < e; p++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                gragh[start].add(end);
                gragh[end].add(start);
            }

            boolean isDividedGraph = false;
            for (int j = 1; j <= v; j++) {
                if (colors[j] == 0) {
                    isDividedGraph = BFS(j, RED);
                }
                if (!isDividedGraph) break;
            }
            if (isDividedGraph) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();


    }

    private static boolean BFS(int node, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        // node의 컬러를 초기화하는 것을 잊지말 것!
        colors[node] = color;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int next : gragh[now_node]) {
                if (colors[now_node] == colors[next]) {
                    return false;
                }

                if (colors[next] == 0) {
                    colors[next] = colors[now_node] * -1;
                    queue.offer(next);

                }
            }
        }
        return true;
    }
}

