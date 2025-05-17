package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 카드 구매하기
public class BOJ_11052 {
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

        dp[1] = p[1];

        for (int i = 2; i <= n; i++) {

            // 작은 것들을 쪼개서 i개를 만드는 것을 고려해줘야하는데
            // 어떻게 해줄 수 있을까?
            // 단순하게 dp[i]를 dp[i-1]+p[i]와 비교하는 것이 아니라,
            // dp

            for (int j = 1; j <= i; j++) {

                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }

        System.out.println(dp[n]);

    }


}
