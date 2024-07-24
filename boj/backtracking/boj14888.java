package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 연산자 끼워놓기
 */
public class boj14888 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] brr;
    static final int MAX = 100 + 1;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[MAX];
        visited = new boolean[MAX];
        brr = new int[4];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }



        backtracking(1, arr[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void backtracking(int depth, int sum) {


        if (depth == n) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (brr[i] > 0) {
                brr[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth]);
                }
                brr[i]++;

            }
        }


    }
}
