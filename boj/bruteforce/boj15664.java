package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj15664 {


    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        func(0, 0, new StringBuilder());
    }

    public static void func(int start, int depth, StringBuilder numberBase) {
        if (depth == m) {
            System.out.println(numberBase);
            return;
        }

        int prevNum = -1;

        for (int i = start; i < arr.length; i++) {
            if (!visited[i] && arr[i] != prevNum) {
                visited[i] = true;
                int lengthBeforeAppend = numberBase.length(); // 백트래킹을 위한 길이 저장

                // 값 추가하고 백트래킹
                numberBase.append(arr[i]);
                if (depth < m - 1) {
                    numberBase.append(" ");
                }

                func(i, depth + 1, numberBase);

                // 백트래킹
                numberBase.setLength(lengthBeforeAppend);
                visited[i] = false;
                prevNum = arr[i];
            }
        }
    }
}


// 하단이 더 직관적인 풀이인듯.
class boj15664_re {
    public static int[] arr, ans;
    public static int N, M;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        ans = new int[N];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ans);
        dfs(0, 0);
        set.forEach(System.out::println);
    }

    public static void dfs(int depth, int t) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int val : arr) {
                sb.append(val + " ");
            }
            set.add(sb.toString());
            sb.append('\n');
            return;
        }
        for (int i = t; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = ans[i];
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
