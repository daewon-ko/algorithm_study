package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 6603 로또
public class boj6603 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n];
            visited = new boolean[n];


            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0,0);
            System.out.println();
        }

    }

    public static void backtracking(int start, int depth) {
        if (depth >=6) {


            // 함수 요소 모두 출력
            System.out.println(sb.toString());
            return;
        }


        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]+" ");
                backtracking(i, depth + 1);
                sb.delete(sb.length() - String.valueOf(arr[i] + " ").length(), sb.length());
                visited[i] = false;
            }
        }
    }
}



