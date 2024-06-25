package boj.barkingdog.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1074 Z문제
public class boj1074 {
    static int n, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int result = recursiveFunc(n, r, c);
        System.out.println(result);
        br.close();
    }

    static int recursiveFunc(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return recursiveFunc(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return half * half + recursiveFunc(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + recursiveFunc(n - 1, r - half, c);
        }
        return 3 * half * half + recursiveFunc(n - 1, r - half, c - half);

    }
}
