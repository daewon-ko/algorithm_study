package boj.backtracking.바킹독;

import java.util.Scanner;

public class boj15649 {
    static int n, m;
    static int arr[];
    static boolean visited[];
    static final int MAX = 8 ;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[MAX];
        visited = new boolean[MAX];

        func(0);
        System.out.println(sb.toString());


    }

    public static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[k] = i + 1;
                func(k + 1);
                visited[i] = false;
            }
        }


    }
}
