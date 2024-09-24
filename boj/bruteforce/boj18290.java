package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * nm과 k(1)
 */
public class boj18290 {
    static int n, m, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

//    static int[] dy = {1, 1, -1, -1};
//    static int[] dx = {1, -1, -1, 1};
    static int[][] arr;
    static boolean[][] visited;

    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j], 1);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(MAX);

    }

    public static void dfs(int y, int x, int sum, int cnt) {

        visited[y][x] = true;

        if (cnt == k) {
            MAX = Math.max(sum, MAX);
        }


        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (inRange(newY, newX) && visited[newY][newX]) {
                dfs(newY, newX, sum +arr[newY][newX], cnt + 1);
//                visited[newY][newX] = false;
            }


        }

        visited[y][x] = false;

    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }


}

class boj18290_re{

        static int n, m, k;
        static int[][] arr;
        static boolean[][] visited;

        static int MAX = Integer.MIN_VALUE;
        static int[] dx = {0, 0, 1, -1}; // 상하좌우
        static int[] dy = {1, -1, 0, 0}; // 상하좌우

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0, 0);

            System.out.println(MAX);
        }

        public static void dfs(int y, int x, int sum, int cnt) {
            if (cnt == k) {
                MAX = Math.max(sum, MAX);
                return;
            }

            for (int i = y; i < n; i++) {
                for (int j = (i == y ? x : 0); j < m; j++) {
                    if (canSelect(i, j)) {
                        visited[i][j] = true;
                        dfs(i, j, sum + arr[i][j], cnt + 1);
                        visited[i][j] = false;
                    }
                }
            }
        }

        public static boolean canSelect(int y, int x) {
            if (visited[y][x]) return false;
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (inRange(newY, newX) && visited[newY][newX]) return false;
            }
            return true;
        }

        public static boolean inRange(int y, int x) {
            return y >= 0 && y < n && x >= 0 && x < m;
        }
    }


