package boj.backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 카드놓기
 */
public class boj5568 {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static final int MAX = 10 + 1;
    static Set<String> set = new HashSet<>();


    /**
     * 백준 카드놓기
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[MAX];
        visited = new boolean[MAX];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(String.valueOf(sc.nextInt()));
        }

        StringBuilder sb = new StringBuilder();
        func(0, sb);

        System.out.println(set.size());

    }

    public static void func(int index, StringBuilder sb) {


        if (index == k) {
            set.add(sb.toString());
            return;
        }

//
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]);
                func(index + 1, sb);
                sb.delete(sb.length() - String.valueOf(arr[i]).length(), sb.length());
                visited[i] = false;
            }
        }
        // arr[index]를 더한다.
        /**
         * 문제는 sb가 공백으로 들어올때이다.
         */

    }


}

