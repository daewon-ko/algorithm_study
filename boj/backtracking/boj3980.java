package boj.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

/**
 * 선발 명단
 */
public class boj3980 {
    static int c;
    static int[][] arr;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());

        while (c != 0) {

            max = Integer.MIN_VALUE;

            arr = new int[11][11];  // 11명의 축구선수
            visited = new boolean[11];

            // 그래프 초기화
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            func(0, 0);
            System.out.println(max);
            c--;
        }

    }

    public static void func(int y, int sum) {
        if (y == 11 ) {
            // static 변수 max와 최댓값 초기화

//            for (int i = 0; i < 11; i++) {
//                if (arr[10][i] != 0) {
//                    int sum = 0;
//                    visited[10][i] = true;
//
//                    for (int k = 0; k < 11; k++) {
//                        for (int j = 0; j < 11; j++) {
//                            if (visited[k][j]) {
//                                sum += arr[k][j];
//                            }
//                        }
//                    }

                    max = Math.max(max, sum);

//                    visited[10][i] = true;

//                }
//            }

            return;
        }

        for (int i = 0; i < 11; i++) {
            if (arr[y][i] != 0 && !visited[i]) {
                visited[i] = true;
                func(y + 1, sum + arr[y][i]);
                visited[i] = false;
            }
        }


//        for (int i = y; i < 11; i++) {
//            for (int j = 0; j < 11; j++) {
//                if (arr[i][j] != 0) {
//                    if (!visited[i][j]) {
//                        visited[i][j] = true;
//                        func(y + 1, x);
//                        visited[i][j] = false;
//                    }
//                }
//            }
//        }

    }
}
