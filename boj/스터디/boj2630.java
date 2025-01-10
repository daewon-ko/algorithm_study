package boj.스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기
public class boj2630 {
    static int n;
    static int [][]graph;
    static final int MAX = 128;
    public static int BLUE_PAPER = 0;
    public static int WHITE_PAPER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[MAX][MAX];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);

        System.out.println(WHITE_PAPER);
        System.out.println(BLUE_PAPER);
    }

    public static void solve(int y, int x, int size) {
        if (validate(y, x, size)) {
            if (graph[y][x] == 1) {
                // BLUE
                BLUE_PAPER++;
                return;
            } else if (graph[y][x] == 0) {
                // WHITE
                WHITE_PAPER++;
                return;
            }
        }

        int newSize = size / 2;
        // 동일 위치에서 새로운 크기의 정사각형
        solve(y, x, newSize);
        // x좌표를 이동하고 새로운 크기의 정사가형
        solve(y, x + newSize, newSize);
        // y좌표를 이동하고 새로운 크기의 정사각형
        solve(y+newSize, x, newSize);
        // x와 y좌표를 이동하고 새로운 크기의 정사각형
        solve(y + newSize, x + newSize, newSize);
    }

    public static boolean validate(int y, int x, int size) {
        int standard = graph[y][x];

        // 쪼개진 그래프에서 크기(n)만큼, 정사각형 내 요소가 같은지 검증한다.
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
