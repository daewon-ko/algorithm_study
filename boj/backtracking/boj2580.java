package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj 2580 스도쿠
 */
public class boj2580 {
    static int[][] arr;
    static boolean[][] visited;
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[10][10];

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (arr[i][j] == 0) {
                    // arr[i][j]를 초기화 하고자 확인
                    checkingX(i, j);
                    if (arr[i][j] == 0) {
                        // x값들을 확인했는데 초기화 못하면 y값들을 확인
                        checkingY(i, j);
                    }

                }
            }
        }


        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (arr[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }





        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static void dfs(int y, int x) {
//        checkDivision(y, x);

        int sum = 0;
        for (int i = 0; i <= 7; i++) {

            int newX = x + dx[i];
            int newY = y + dy[i];

            sum+=arr[newY][newX];

        }

        arr[y][x] = 45 - sum;

    }

//    public static int checkDivision(int y, int x) {
//        if ((y >= 1 && y <= 3) && (x >= 1 && x <= 3)) {
//            return 1;
//        }
//    }

    /**
     * 동일한 Y축에서 자기 자신을 제외하고 나머지 x는 0이되면 안된다.
     */
    public static void checkingX(int y, int x) {

        if (y > 9 || x > 9) {

            return;
        }

        int sum = 0;


        for (int i = 1; i <= 9; i++) {

            if (i == x) {
                continue;
            }

            int number = arr[y][i];

            if (number == 0) {
                return;
            }

            sum += number;

        }

        arr[y][x] = 45 - sum;
    }

    public static void checkingY(int y, int x) {
        if (y > 9 || x > 9) {
            return;
        }
        int sum = 0;

        for (int i = 1; i <= 9; i++) {
            if (y == i) {
                continue;
            }

            if (arr[i][x] == 0) {
                return;
            }
            sum += arr[i][x];
        }

        arr[y][x] = 45 - sum;
        }
    }

