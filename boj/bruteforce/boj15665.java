package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj15665 {
    static int n,m;
    static int [] arr;
    static Set<String> set;
    static int [] ans;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        ans = new int[n];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ans);
        dfs(0, 0);
        set.forEach(System.out::println);
    }

    public static void dfs(int depth, int t) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : arr) {
                sb.append(val + " ");
            }
            set.add(sb.toString());
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
                arr[depth] = ans[i];
                dfs(depth + 1, i + 1);
//                visited[i] = false;
            }
        }
    }

