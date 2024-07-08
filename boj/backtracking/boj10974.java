package boj.backtracking;

//좋은수열

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj10974 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] visited;

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];

        arr = new int[n];


        func(0);
        System.out.println(sb.toString());
    }

    public static void func(int k) {
//        list.add(k);
        if (k == n) {
            for (int i : arr) {
                sb.append(i + " ");
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
