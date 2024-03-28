package boj;

import java.util.*;
import java.io.*;

// 유기농배추
public class boj1012 {
    static int M, N, K;
    static int[][] cabbage;
    //    static boolean[][] visit;
    static int MAX = 50 + 10;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int x, int y) {
        cabbage[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cabbage[cx][cy] == 1) {
                dfs(cx, cy);
            }

        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            cabbage = new int[MAX][MAX];

            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p2 + 1][p1 + 1] = 1;
            }

            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= M; y++) {
                    if (cabbage[x][y] == 1) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

}
