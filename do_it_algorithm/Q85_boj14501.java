package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q85_boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n + 2];
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i > 0; i--) {
            if (i + T[i] > n + 1) {
                D[i] = D[i + 1];
            }
            else{
                D[i] = Math.max(D[i+1],P[i] +D[i+T[i]]);
            }
        }

        System.out.println(D[1]);


    }
}
