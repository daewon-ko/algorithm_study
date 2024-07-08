package boj.재귀.바킹독;

import java.util.Scanner;

/**
 * 백준 하노이의탑 순서
 */
public class boj11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((1 << n) - 1);
        func(1, 3, n);
        System.out.println(sb.toString());
        sc.close();



    }

    static void func(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        func(6 - a - b, b, n - 1);
    }
}
