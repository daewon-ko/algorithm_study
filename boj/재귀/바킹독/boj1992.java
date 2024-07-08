package boj.재귀.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 쿼드트리
 */
public class boj1992 {
    static int[][] graph;
    static final int MAX = 64 + 10;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
            }
        }

//        sb.append("(");
        recursive(1, 1, n);
//        sb.append(")");
        System.out.println(sb.toString());
    }

    public static void recursive(int y, int x, int size) {

//        if (size < 1) {
//            return;
//        }


        // graph에서 모든 수가 같다면,
        if (validateGraph(y, x, size)) {
            if (graph[y][x] == 0) {
                sb.append("0");
                return;
            } else if (graph[y][x] == 1) {
                sb.append("1");
                return;
            }
        }

        int newSize = size / 2;

        sb.append("(");
        recursive(y, x, newSize);
        recursive(y, x + newSize, newSize);
        recursive(y + newSize, x, newSize);
        recursive(y + newSize, x + newSize, newSize);
        sb.append(")");


    }

    public static boolean validateGraph(int y, int x, int size) {
        int standard = graph[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (standard != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
