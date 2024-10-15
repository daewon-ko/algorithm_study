package boj.bruteforce;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 9095 1,2,3 더하기
 */
public class boj9095 {
    static int t, n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            bw.write(dp[n] + "\n");
        }
        bw.flush();

    }
}


class boj9095_bruteForce {
    static int n, t;
    static int cnt;
    static Map<Integer, Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            bruteForce(0);

            System.out.println(cnt);

        }


    }

    public static void bruteForce(int sum) {
        if (sum == n) {
            cnt++;
            return;
        } else if (sum > n) {
            return;
        }
        else {
            for (int i = 1; i <= 3; i++) {
                bruteForce(sum + i);
            }
        }
    }
    }


