package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj15666 {


    static int n, m;
    static int[] arr;
    static Set<String> set;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        set.forEach(System.out::println);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : ans) {
                sb.append(val + " ");
            }
            set.add(sb.toString());
            sb.append('\n');
            return;
        }
        for (int i = start; i < n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
                ans[depth] = arr[i];
                dfs(depth + 1, i);
//                visited[i] = false;
//            }
        }
    }
}


// Set을 안 푼 풀이
class boj15666Re{
    static int n, m;
    static int[] arr;
    static Set<String> set;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

    }


    public static void dfs(int depth, int start) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : ans) {
                sb.append(val).append(' ');
            }
            System.out.println(sb.toString());
            return;
        }

        int prev = -1; // 이전에 선택한 숫자를 저장
        for (int i = start; i < n; i++) {
            if (prev != arr[i]) { // 중복된 숫자 건너뛰기
                ans[depth] = arr[i];
                prev = arr[i]; // 이전 숫자 갱신
                dfs(depth + 1, i); // i를 넘겨 중복 선택 허용
            }
        }
    }
}

