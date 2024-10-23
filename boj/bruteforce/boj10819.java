package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10819 {
    static int n;
    static int[] arr;
    static int [] brr;
    static boolean [] visited;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        brr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        System.out.println(MAX);



    }

    public static void backtracking(int cnt) {
        if (cnt == n) {

            int sum =0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(brr[i] - brr[i + 1]);
            }

            MAX = Math.max(sum, MAX);
            return;

        }



        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                brr[cnt] = arr[i];  //cnt변수를 왜 넣어야할까?
                backtracking(cnt + 1);
                visited[i] = false;
            }

        }

    }
}
