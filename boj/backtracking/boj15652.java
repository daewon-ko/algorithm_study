package boj.backtracking;

import java.util.Scanner;

/**
 * 백준 n과m(4)
 *
 */
public class boj15652 {
    static int n,m;
    static final int MAX = 8 +1;
    static int [] arr;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[MAX];
        visited = new boolean[MAX];

        n = sc.nextInt();
        m = sc.nextInt();

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
        for (int i = start; i <=n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
                arr[depth]  = i;
                func(i , depth + 1);
//                visited[i] = false;
//            }
        }
    }

}
