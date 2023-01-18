package do_it_algorithm;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Q23 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(i)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int x) {
        if (visited[x]) {
            return false;
        } else {
            visited[x] = true;
            int size = graph.get(x).size();
            for (int i = 0; i < size; i++) {
                int value = graph.get(x).get(i);
                if (!visited[value]) {
                    dfs(value);
                }
            }
            return true;
        }
    }

    private static boolean bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        if (visited[x]) {
            return false;
        } else {
            queue.add(x);
            visited[x] = true;

            while (!queue.isEmpty()) {
                x = queue.remove();
                int size = graph.get(x).size();
                for (int i = 0; i < size; i++) {
                    int value = graph.get(x).get(i);

                    if (!visited[value]) {
                        queue.add(value);
                        visited[value] = true;
                    }
                }
            }
            return true;
        }
    }
}
