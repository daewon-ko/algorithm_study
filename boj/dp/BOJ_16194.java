package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        // dp 정의 : i개의 카드를 갖기 위한 금액의 최댓값
        int[] dp = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = p[1];

        // dp 배열에 최댓값들을 채워 넣는다.

        // dp[1] = p[1]


        // dp 최적화 수행
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
            }
        }

        System.out.println(dp[n]);
    }


}
