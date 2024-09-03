package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {
    public static int[][] board;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N]; // 2차원 배열 생성

        nQueen(0);
        System.out.println(count);

    }

    public static void nQueen(int y) {
        if (y == N) {
            count++;
            return;
        }

        for (int x = 0; x < N; x++) {
            if (isSafe(y, x)) {
                board[y][x] = 1; // 퀸을 놓음
                nQueen(y + 1); // 다음 행으로 재귀 호출
                board[y][x] = 0; // 퀸을 제거 (백트래킹)
            }
        }


    }


    public static boolean isSafe(int y, int x) {
        // 같은 열 체크
        for (int i = 0; i < y; i++) {
            if (board[i][x] == 1) {
                return false;
            }
        }

        // 대각선 체크
        // 좌상단 대각선
        for (int i = y, j = x; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 우상단 대각선
        for (int i = y, j = x; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 좌하단 대각선
        for (int i = y, j = x; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 우하단 대각선
        for (int i = y, j = x; i < N && j < N; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
