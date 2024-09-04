package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 사탕게임
 */
public class boj3085 {
    static char[][] arr;
    static int n;
    static boolean[][] visited;
    static final int MAX = 50 + 1;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        // 상,하,좌,우에 다른색이 있는지 판별
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 이동한 좌표의 색이 현재 좌표의 색과 같으면 스킵
            if (arr[newY][newX] == arr[y][x]) {
                continue;
            }

            // 색이 다를경우 좌표를 변경한다.
            char currentC = arr[y][x];
            arr[y][x] = arr[newY][newX];
            arr[newY][newX] = currentC;


            // 현재 좌표(y,x)에서 상,하,좌,우로 같은 색의 좌표를 계속해서 찾는다.



        }

    }
}

class boj3085Ref{
    static char[][] arr;
    static int n;
    static final int MAX = 50;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (!inRange(newY, newX)) {
                continue;
            }

            if (arr[y][x] != arr[newY][newX]) {
                swap(y, x, newY, newX);
                check();
                swap(y, x, newY, newX);
            }
        }
    }

    public static void check() {

        // 행검증
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    count++;
                }else{
                    count = 1;
                }
                answer = Math.max(answer, count);
            }
        }

        // 열검증
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    count++;
                }else{
                    count = 1;
                }
                answer = Math.max(answer, count);
            }
        }
    }

    public static void swap(int y, int x, int newY, int newX) {
        char temp = arr[y][x];
        arr[y][x] = arr [newY][newX];
        arr[newY][newX] = temp;
    }

    public static boolean inRange(int y, int x) {

        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
