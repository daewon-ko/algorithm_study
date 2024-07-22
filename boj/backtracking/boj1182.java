package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분수열의 합
 *
 * 1. 왜 시간초과가 날까?
 *
 */
public class boj1182 {
    static int n,m;
    static final int MAX = 20 +1;
    static int [] arr;
    static boolean [] visited;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[MAX];
        visited = new boolean[MAX];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1,0);
        if (m == 0) {
            cnt--;
        }
        System.out.println(cnt);

    }
    static void backtracking(int index, int sum) {
        // 재귀적으로 들어가야한다.
        //
        if (index == n + 1) {
            if (sum == m) {
                cnt++;
            }
            return;
        }

        backtracking(index + 1, sum + arr[index]);
        backtracking(index + 1, sum);


    }
}
