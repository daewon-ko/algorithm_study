package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 스티커 붙이기
public class boj18808 {
    static int n,m,k;
    static int [][] graph;

    static boolean [][]visited;
    static List<Sticker> stickers = new ArrayList<>();
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] map = new int[y][x];
            for (int a = 0; i < y; a++) {
                st = new StringTokenizer(br.readLine());
                for (int b = 0; i < x; b++) {
                    map[a][b] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(y, x, map));

        }

        func(0,0);






    }

    public static void func(int cnt, int sum) {

        if (cnt == k) {
            MAX = Math.max(MAX, sum);
        }

        Sticker sticker = stickers.get(cnt);
        int pollY = sticker.y;
        int pollX = sticker.x;
        int[][] stickerMap = sticker.map;

        // 회전하지 않은 채로 스티커를 붙인다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pollY > n - i || pollX > m - j) {
                    continue;
                }
                int num = attach(i, j, stickerMap);
                if (num == -1) {
                    continue;
                }

                func(cnt + 1, sum + num);
                return;

            }
        }

        // 회전하며 스티커를 붙인다.

        for (int i = 0; i < 3; i++) {

        }





    }


    public static int attach(int y, int x, int[][] stickerMap) {
        int result = 0;

        for (int i = 0; i < stickerMap.length; i++) {
            for (int j = 0; j < stickerMap[0].length; j++) {

            }
        }


        return 0;
    }

    static class Sticker{
        private int y;
        private int x;
        private int [][] map;

        public Sticker(final int y, final int x, final int[][] sticker) {
            this.y = y;
            this.x = x;
            this.map = sticker;
        }
    }
}
