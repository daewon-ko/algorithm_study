package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
    static int MOD = 1_000_000_009;
    static int[][] dp = new int[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2]= (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3]= (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = (int) ((long) dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(result).append('\n');
        }

        System.out.println(sb);


    }
}
