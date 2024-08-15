package boj.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 백준 애너그램
 */
public class boj6443 {
    static int n;
    static int l;
    static final int MAX = 20 + 1;

    static String[] arr;
    static String[] brr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            l = line.length();
            arr = new String[MAX];
            brr = new String[MAX];
            visited = new boolean[MAX];

            // 입력
            for (int j = 0; j < l; j++) {
                arr[j] = String.valueOf(line.charAt(j));
            }

            func( l, 0);


        }

    }

    public static void func( int l, int depth) {
        if (l == depth) {
            //lined
            for (int i = 0; i < l; i++) {
                System.out.print(brr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < l; i++) {
            if (!visited[i]) {
                visited[i] = true;

                brr[i] = arr[depth];

                func( l, depth + 1);
                visited[i] = false;
            }
        }
    }
}
