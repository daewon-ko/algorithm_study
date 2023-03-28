package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사전
public class Q82_boj1256 {
    static double[][] dp = new double[101][101];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double k = Double.parseDouble(st.nextToken());
        if (check(n, m) < k) {
            System.out.println("-1");
        } else {
            makeString(n, m, k);
            System.out.println(sb.toString());
        }


    }

    static double check(int a, int z) {
        if (a == 0 || z == 0) {
            return 1;
        }
        if (dp[a][z] != 0) return dp[a][z];

        return dp[a][z] = Double.min(check(a - 1, z) + check(a, z - 1), 1000000001);
    }

    static void makeString(int a, int z, double k) {
        if (a == 0) {
            for (int i = 0; i < z; i++) {
                sb.append("z");
            }
            return;
        }
        if (z == 0) {
            for (int i = 0; i < a; i++) {
                sb.append("a");
            }
            return;
        }
        // a로 시작하게 되는 문자열의 개수 check
        double check1 = check(a - 1, z);

        if (k > check1) {    // a로 시작하게 되면 K번째 문자열을 포함하는 문자열을 만들지 못한다.
            sb.append("z");
            makeString(a,z-1,k-check1);  // z로 시작하기 때문에 a로 시작하는 문자열들을 제외해준다.
        }
        else{
            sb.append("a");
            makeString(a - 1, z, k);
        }

    }
}
