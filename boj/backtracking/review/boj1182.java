package boj.backtracking.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * for문 -> 시간초과 발생
 * 왜일까?
 */
public class boj1182 {
    static int n, s;
    static int cnt = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());


        arr = new int[n];
        visited = new boolean[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);

//        if (s == 0) {
//            cnt--;
//        }

        System.out.println(cnt);

    }

    public static void backtracking(int depth, int sum) {

        if (depth == n) {
            if (sum == s) {
                cnt++;
            }

            return;
        }
//
//        backtracking(depth + 1, sum);
//        backtracking(depth + 1, sum + arr[depth]);


        for (int i = depth; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int sum2 = 0;
                backtracking(depth + 1, sum2);
                sum2 += arr[i];
                backtracking(depth + 1, sum2);
                visited[i] = false;
            }
        }
    }
}
