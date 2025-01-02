package boj.스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 체스판 다시 칠하기
public class boj1018 {
    static int n, m;
    static char[][] graph;
    static int MAX = 50 + 10;
    static int answer = Integer.MAX_VALUE; // 구하고자 하는 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[MAX][MAX];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }


//        char[][] temp = new char[MAX][MAX];
//
//        for (int i = 0; i < MAX; i++) {
//            for (int j = 0; j < MAX; j++) {
//                temp[i][j] = graph[i][j];
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {


                answer = Math.min(answer, solve(graph, i, j));
            }
        }

        System.out.println(answer);

    }

    public static int solve(char[][] graph, int y, int x) {


        int count = 0; // 특정 좌표점에서 다시 칠해야 하는 점의 개수
        int endY = y + 8;
        int endX = x + 8;

        if (!inRange(y, x, endY, endX)) {
            return Integer.MAX_VALUE;
        }

        for (int i = y; i < endY; i++) {
            for (int j = x; j < endX; j++) {

                // 같은 행의 다음열과 비교
                if (graph[i][j] == graph[i][j + 1]) {

                    count++;

//                    if (graph[i][j] == 'W') {
//                        answer++;
//
//                    } else if (graph[i][j] == 'B') {
//                        answer++;
//
//                    }
                }
                if (graph[i][j] == graph[i + 1][j]) {
                    count++;
                }


            }
        }

        return count;
    }

    public static boolean inRange(int y, int x, int endY, int endX) {
        return y >= 0 && y < n && x >= 0 && x < m && endY >= 0 && endY < n && endX >= 0 && endX < m;
    }
}

