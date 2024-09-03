//
//
//package boj.backtracking;
//
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
///**
// * 비숍
// */
//public class boj1799 {
//    static int n;
//    static final int MAX = 10 + 1;
//    static int[][] arr;
//
//    static boolean[][] visited;
//
//    static int[] dx = {1, 1, -1, -1};
//    static int[] dy = {1, -1, -1, 1};
//    static int cnt = 0;
//    static int zero_land = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//
//        arr = new int[MAX][MAX];
//        visited = new boolean[MAX][MAX];
//
//        for (int i = 1; i <= n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= n; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (!visited[i][j] && arr[i][j] == 1) {
//                    dfs(i, j);
//                }
//            }
//        }
//
//        System.out.println(cnt);
//
//
//    }
//
//    public static void dfs(int y, int x) {
//        visited[y][x] = true;
//
//        for (int i = 0; i < 4; i++) {
//            int vector_cnt = 1;
//
//            int newY = vector_cnt * dy[i] + y;
//            int newX = vector_cnt * dx[i] + x;
//
//            while (inRange(newY, newX) && !visited[newY][newX] && arr[newY][newX] == 1) {
//                dfs(newY, newX);
//                cnt++;
//            }
//
//
//        }
//    }
//
//    public static boolean inRange(int newY, int newX) {
//        return newY >= 1 && newY <= n && newX >= 1 && newX <= n;
//    }
//}
//
//class boj1799RefAnotherPerson {
//    static int n;
//    static int[][] arr;
//    static int[] dx = {1, 1, -1, -1};
//    static int[] dy = {1, -1, -1, 1};
//    static final int MAX = 10 + 1;
//
//    static int black_cnt = 0;
//    static int while_cnt = 0;
//    static boolean[][] black_visited;
//    static boolean[][] white_visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//
//        arr = new int[MAX][MAX];
//        black_visited = new boolean[MAX][MAX];
//        white_visited = new boolean[MAX][MAX];
//
//        for (int i = 1; i <= n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= n; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        black_backtracking(black_visited, 1, 1, 0);
//        white_backtracking(white_visited, 1, 2, 0);
//
//
//    }
//
//    public static void black_backtracking(boolean[][] black_visited, int y, int x, int black_cnt) {
//        while_cnt = Math.max(while_cnt, black_cnt);
//
//        if (y > n) {
//            return;
//        }
//
//        if (x > n) {
//            y+=1;
//            x = (y % 2 == 0) ? 2 : 1;
//        }
//
//        // (y,x)에 비숍ㅇ르 놓을 수 있을 때
//        if (canMove(black_visited, y, x)) {
//            black_visited[y][x] = true;
//            black_backtracking(black_visited, y, x + 2, black_cnt + 1);
//            black_visited[y][x] = false;
//         }
//        // (y,x)에 비숍을 놓을 수 있지만 놓지 않고 옆으로 이동했을 때
//        black_backtracking(black_visited, y, x + 2, black_cnt);
//    }
//}
//
