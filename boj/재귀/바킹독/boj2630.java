package boj.재귀.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 */
public class boj2630 {
    static int n;
    static final int MAX = 128 + 10;
    static int [][] graph;
    static int WHITE_PAPER = 0;
    static int BLUE_PAPER = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        graph = new int[MAX][MAX];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursiveFunction(1, 1, n);
        System.out.println(WHITE_PAPER);
        System.out.println(BLUE_PAPER);
    }

    public static void recursiveFunction(int y, int x, int size) {
        if (validateGraph(y, x, size)) {
            if (graph[y][x] == 1) {
                BLUE_PAPER++;
                return;
            } else if (graph[y][x] == 0) {
                WHITE_PAPER++;
                return;
            }
        }

        int newSize = size / 2;

        recursiveFunction(y, x, newSize);
        recursiveFunction(y, x + newSize, newSize);
        recursiveFunction(y + newSize, x, newSize);
        recursiveFunction(y + newSize, x + newSize, newSize);


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
