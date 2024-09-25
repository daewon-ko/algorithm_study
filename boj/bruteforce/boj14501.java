package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

/**
 * 백준 퇴사
 */
public class boj14501 {
    static int n;
    static int[] t;
    static int[] p;
    static boolean[] visited;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n + 1];
        p = new int[n + 1];
        visited = new boolean[n + 1];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        func(1, 0);
        System.out.println(MAX);

    }

    public static void func(int day, int sum) {

        if (day > n + 1) {
            return;
        } else {

            MAX = Math.max(MAX, sum);

        }


        for (int i = day; i <= n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
            func(i + t[i], sum + p[i]);
//                visited[i] = false;
//            }
        }


    }
}


// DP 방식 풀이
class boj14501_RE {

    static int[] t, p, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 2];  // 퇴사일 이후를 고려해 n+2 크기로 설정

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            if (i + t[i] <= n + 1) {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            } else {
                dp[i] = dp[i + 1];  // 상담을 할 수 없으면 다음 날의 값을 그대로 복사
            }
        }

        // 전체 날짜 중에서 얻을 수 있는 최대 이익 찾기
        int maxProfit = 0;
        for (int i = 1; i <= n; i++) {
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        System.out.println(maxProfit);  // 전체 날짜에서 얻을 수 있는 최대 이익 출력ㄱ
    }
}



