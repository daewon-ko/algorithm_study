package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단수
public class Q88_boj10844 {
    static int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long d[][] = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            d[1][i] =1;
        }
        /*
        mod를 나누는 기준은?
         */
        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][1]%mod;
            d[i][9] = d[i-1][8]%mod;
            for (int j = 1; j <= 8; j++) {
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + d[n][i]) % mod;
        }
        System.out.println(sum);


    }
}
