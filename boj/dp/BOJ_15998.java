package boj.dp;

import java.util.*;
import java.io.*;

public class BOJ_15998 {
    static final int MOD = 1_000_000_009;
    static final int MAX = 1_000_000;
    static long[] dp = new long[MAX + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp 초기값
        dp[0] = 1; // 0을 만드는 경우는 아무것도 안 더한 한 가지
        dp[1] = 1; // [1]
        dp[2] = 2; // [1+1], [2]
        dp[3] = 4; // [1+1+1], [1+2], [2+1], [3]

        // 점화식 적용
        for (int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\\n");
        }

        System.out.print(sb);
    }


}
