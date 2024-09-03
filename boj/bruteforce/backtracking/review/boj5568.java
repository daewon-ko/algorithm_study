package boj.backtracking.review;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj5568 {
    static int n, k;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        backtracking(0, sb, 0);
        System.out.println(set.size());

    }

    public static void backtracking(int depth, StringBuilder sb, int cnt) {
        if (cnt == k) {
            set.add(sb.toString());
            return;
        }

        if (depth == n) {
            return;
        }

        int length = sb.length();

        backtracking(depth + 1, sb, cnt);
        backtracking(depth + 1, sb.append(arr[depth]), cnt + 1);
        sb.setLength(length);
//        sb.delete(sb.length() - String.valueOf(arr[depth]).length(), sb.length());

    }
}
