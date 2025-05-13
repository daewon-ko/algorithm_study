package boj.dp;

import java.sql.SQLOutput;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열
public class BOJ_11053 {

    static int [] arr;
    static int [] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        // i번째 원소를 마지막 원소로 하는 가장 긴 증가하는 부분 수열의 길이
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }


        System.out.println(max);

    }
}
