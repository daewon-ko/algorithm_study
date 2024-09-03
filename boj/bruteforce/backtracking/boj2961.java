package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 도영이가 만든 맛있는 음식
 */
public class boj2961 {
    static int n;
    static final int MAX = 10 +1;
    static int [] arr;
    static int [] brr;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        arr = new int[MAX];
        brr = new int[MAX];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
        }

        func(1, 1, 0);
        System.out.println(min);

    }

    public static void func(int index, int sum_arr, int sum_brr) {
        if (index == n + 1) {
            if (sum_arr != 1 && sum_brr != 0) {
                min = Math.min(min, Math.abs(sum_arr - sum_brr));
            }

            return;
        }

        func(index + 1, sum_arr, sum_brr);
        func(index + 1, sum_arr * arr[index], sum_brr + brr[index]);
    }
}
