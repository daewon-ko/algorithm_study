package boj.dp;

import java.util.Scanner;

//백준 2xn 타일링 2
public class BOJ_11727 {


    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];  // dp[i] = 2×i 직사각형을 채우는 방법 수

        dp[1] = 1; // 2x1은 2x1 타일 하나로만 가능
        if (n >= 2) dp[2] = 3; // 2x2는 (2x1 두 개, 1x2 두 개, 2x2 한 개)

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
        }

        System.out.println(dp[n]);
    }


}
