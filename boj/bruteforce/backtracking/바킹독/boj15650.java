package boj.backtracking.바킹독;

import java.util.Scanner;

public class boj15650 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static final int MAX = 8 + 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[MAX];
        visited = new boolean[MAX];

        func(1, 0);
        System.out.println(sb.toString());
    }

    public static void func(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                func(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }
}


