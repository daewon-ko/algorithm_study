package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 외판원 순회 2
public class boj10971 {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    visited = new boolean[n];
                    dfs(i, j, 0, 0);
                }
            }
        }

        System.out.println(MIN);

    }

    public static void dfs(int y, int x, int sum, int cnt) {

        // 모든 i를 방문했다면, 해당 좌표에서 start와 이어져있는지를 확인한다.
        if (cnt == n) {

            MIN = Math.min(MIN, sum);
            return;

        }




        // start 변수가 존재하는지 확인한다.
        for (int i = 0; i < n; i++) {


            if (arr[y][i] != 0 && !visited[i]) {
                visited[i] = true;
                int number = arr[y][i];
                sum += number;
                dfs(x, y, sum, cnt + 1);
                visited[i] = false;

            }

        }



    }
}
