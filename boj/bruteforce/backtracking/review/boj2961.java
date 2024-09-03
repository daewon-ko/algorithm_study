package boj.backtracking.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2961 {
    static int n;

    // srr: 신맛, brr : 쓴맛

    static int[] srr;
    static int[] brr;

    static int cnt = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        srr = new int[n];
        brr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            srr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
        }


        backtracking(0, 1, 0);

        System.out.println(answer);

    }

    public static void backtracking(int depth, int sour, int bitter) {

        if (depth == n) {
            if (cnt > 0) {
                answer = Math.min(answer, Math.abs(sour - bitter));
            }

            return;
        }

        backtracking(depth + 1, sour, bitter);

        cnt++;
//        backtracking(depth + 1, sour * srr[depth], bitter);
        backtracking(depth + 1, sour * srr[depth], bitter + brr[depth]);
        cnt--;
//        backtracking(depth + 1, sour, bitter + brr[depth]);

    }
}
