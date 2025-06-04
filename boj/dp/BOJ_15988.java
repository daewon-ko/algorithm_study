package boj.dp;

import java.util.*;

public class BOJ_15988 {
    static final int MOD = 1_000_000_009;
    static long[] dp = new long[1_000_001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 초기값
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 미리 dp 배열 채워두기
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }

        // 테스트 케이스 처리
        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }


    }
}

