package boj.dp;

import java.util.Scanner;

public class BOJ_1699 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] dp = new int[N + 1];

            // 초기화
            for (int i = 1; i <= N; i++) {
                dp[i] = i; // 최악의 경우 (1^2 + 1^2 + ... i번)
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }

            System.out.println(dp[N]);
        }
    }


