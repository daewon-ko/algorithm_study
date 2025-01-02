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

        int start = graph[y][x];

        for (int i = y; i < endY; i++) {
            for (int j = x; j < endX; j++) {

                // 같은 행의 다음열과 비교
                if (start == graph[i][j + 1]) {

                    count++;

                    if (start == 'W') {
                        start = 'M';
                    } else if (start == 'M') {
                        start = 'W';
                    }

                }

                start = (start == 'W') ? 'M' : 'W';

            }
        }

        return count;
    }

    public static boolean inRange(int y, int x, int endY, int endX) {
        return y >= 0 && y < n && x >= 0 && x < m && endY >= 0 && endY < n && endX >= 0 && endX < m;
    }
}


class bo1018Re{



    public class Main {
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


            for (int i = 0; i < n-7; i++) {
                for (int j = 0; j < m-7; j++) {
                    answer = Math.min(answer, solve( i, j));
                }
            }

            System.out.println(answer);

        }

        public static int solve(int y, int x) {


            int count = 0; // 특정 좌표점에서 다시 칠해야 하는 점의 개수
            int endY = y + 8;
            int endX = x + 8;


            if(!inRange(y,x,endY,endX)){
                return Integer.MAX_VALUE;
            }


            char start = graph[y][x];

            for (int i = y; i < endY; i++) {
                for (int j = x; j < endX; j++) {

                    // 같은 행의 다음열과 비교
                    if (start == graph[i][j]) {
                        count++;

                    }

                    start = (start == 'W') ? 'B' : 'W';

                }
                start = (start == 'W') ? 'B' : 'W';
            }

            count = Math.min(count, 64 - count);
            return count;
        }

        public static boolean inRange(int y, int x, int endY, int endX) {
            return y >= 0 && y < n && x >= 0 && x <m && endY <=n &&  endX <=m;
        }
    }

    // 백준 체스판 다시 칠하기
}

