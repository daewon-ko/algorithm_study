package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * n과 m(8)
 */
public class boj15657 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static final int MAX = 8 + 1;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        backtracking(0, 0);

    }

    public static void backtracking(int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < list.size(); i++) {

//                if (i != list.size()-1 && list.get(i) > list.get(i + 1)) {
//                    return;
//                }

                System.out.printf(list.get(i) + " ");
            }
            System.out.println();

            return;

        }

        for (int i = start; i < n; i++) {

            list.add(arr[i]);
            backtracking(depth + 1, i);
            list.remove(list.size() - 1);
        }

    }
}
