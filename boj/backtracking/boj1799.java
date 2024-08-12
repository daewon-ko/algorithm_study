package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비숍
 */
public class boj1799 {
    static int n;
    static final int MAX = 10 + 1;
    static int[][] arr;

    static boolean[][] visited;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int cnt = 0;
    static int zero_land = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);


    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int vector_cnt = 1;

            int newY = vector_cnt * dy[i] + y;
            int newX = vector_cnt * dx[i] + x;

            while (inRange(newY, newX) && !visited[newY][newX] && arr[newY][newX] == 1) {
                dfs(newY, newX);
                cnt++;
            }


        }
    }

    public static boolean inRange(int newY, int newX) {
        return newY >= 1 && newY <= n && newX >= 1 && newX <= n;
    }
}

class boj1799RefAnotherPerson {
    static int n;
    static int[][] arr;
    static boolean[][] black_visited;
    static boolean[][] white_visited;

    static int white_cnt = 0;
    static int black_cnt = 0;

    static final int MAX = 10 + 1;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[MAX][MAX];
        black_visited = new boolean[MAX][MAX];
        white_visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        blackBacktracking(black_visited, 1, 1, 0);
        whiteBacktracking(white_visited, 1, 2, 0);

        System.out.println(white_cnt + black_cnt);

    }

    private static void blackBacktracking(boolean[][] blackVisited, int y, int x, int cnt) {
        black_cnt = Math.max(black_cnt, cnt);
        if (y > n) {
            return;
        }
        if (x > n) {
            y += 1;
            x = (y % 2 == 0) ? 2 : 1;
        }

        if (canMove(blackVisited, y, x)) {
            blackVisited[y][x] = true;
            blackBacktracking(black_visited, y, x + 2, cnt + 1);
            blackVisited[y][x] = false;
        }

        blackBacktracking(black_visited, y, x + 2, cnt);
    }
    private static void whiteBacktracking(boolean[][] whiteVisited, int y, int x, int cnt) {
        white_cnt = Math.max(white_cnt, cnt);

        if (y > n) {
            return;
        }
        if (x > n) {
            y+=1;
            x = (y % 2 == 0) ? 1 : 2;
        }

        if (canMove(whiteVisited, y, x)) {
            whiteVisited[y][x] = true;
            whiteBacktracking(white_visited, y, x + 2, cnt + 1);
            whiteVisited[y][x] = false;
        }

        whiteBacktracking(white_visited, y, x + 2, cnt);
    }

    public static boolean canMove(boolean[][] visited, int y, int x) {
        if (arr[y][x] == 0) {

            return false;
        }

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            for (int j = 1; j <= n; j++) {
                if (inRange(newY, newX)) {
                    if(visited[newY][newX]) {return false;}

                    newY += dy[i];
                    newX += dx[i];
                }
            }
        }
        return true;
    }

    public static boolean inRange(int newY, int newX) {
        return newY>=1 && newY<=n && newX>=1 && newX<=n;
    }

}

