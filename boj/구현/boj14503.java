package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 로봇 청소기
public class boj14503 {
    static int n, m;


    // 각각 북,동,남,서 방향
    static int[] directions = {0, 1, 2, 3};

    static int[][] graph;
    static boolean[][] isCleaned;

    // 로봇 시작점 및 시작방향
    static int robotStartY;
    static int robotStartX;
    static int robotDirection;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        isCleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine());


        cnt = 0;

        // 로봇청소기 관련 입력
        robotStartY = Integer.parseInt(st.nextToken());
        robotStartX = Integer.parseInt(st.nextToken());
        robotDirection = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(robotStartY, robotStartX, robotDirection);
        System.out.println(cnt);

    }

    public static void dfs(int y, int x, int direction) {

        if (!isCleaned[y][x]) {
            isCleaned[y][x] = true;
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int newY = y + directions[i];
            int newX = x + directions[i];

//            // 범위 검사 필요하다.
//            if (!inRange(newY, newX)) {
//                break;
//            }

            // 주변 4칸이 모두 청소가 된 빈칸일 경우
            if (graph[newY][newX] == 0 && isCleaned[newY][newX]) {

                // 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
                move(y, x, direction);

            } // 주변 4칸 중 청소되지 않은 빈칸이 있을 경우
            else if (graph[newY][newX] == 0 && !isCleaned[newY][newX]) {
                direction = direction % 4 + 1; // 90도 회전
                move(y, x, direction);


            }
        }


    }


    private static void move(int y, int x, int direction) {
        if (direction == 0) {
            // 범위를 넘어서거나 뒤칸이 벽이면 작동을 멈춘다.
            if (y + 1 >= n && graph[y + 1][x] == 1) {
                return;
            }
            dfs(y + 1, x, direction);


        } else if (direction == 1) {
            if (x - 1 <= 0 && graph[y][x - 1] == 1) {
                return;
            }
            dfs(y, x - 1, direction);

        } else if (direction == 2) {

            if (y - 1 <= 0 && graph[y - 1][x] == 1) {

                return;
            }
            dfs(y - 1, x, direction);

        } else if (direction == 3) {

            if (x + 1 >= m && graph[y][x + 1] == 1) {
                return;
            }
            dfs(y, x + 1, direction);

        }
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}

class boj14504Ref1 {


    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0}; // 행 이동
    static int[] dy = {0, 1, 0, -1}; // 열 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행 크기
        int m = Integer.parseInt(st.nextToken()); // 열 크기

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 로봇 초기 위치 (행)
        int c = Integer.parseInt(st.nextToken()); // 로봇 초기 위치 (열)
        int direction = Integer.parseInt(st.nextToken()); // 초기 방향

        // 지도 정보 입력 받기
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 결과 출력
        System.out.println(clean(graph, r, c, direction));
    }

    static int clean(int[][] graph, int r, int c, int direction) {
        int count = 0; // 청소한 칸의 개수

        while (true) {
            // 1. 현재 위치를 청소
            if (graph[r][c] == 0) {
                graph[r][c] = 2; // 청소 완료 표시
                count++;
            }

            // 2. 왼쪽 방향 탐색
            boolean foundCleanable = false;
            for (int i = 0; i < 4; i++) {
                // 왼쪽으로 회전
                direction = (direction + 3) % 4;
                int nx = r + dx[direction];
                int ny = c + dy[direction];

                // 청소되지 않은 칸이 있는 경우
                if (graph[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    foundCleanable = true;
                    break;
                }
            }

            // 3. 네 방향 모두 청소 불가능한 경우
            if (!foundCleanable) {
                // 후진
                int backDirection = (direction + 2) % 4;
                int nx = r + dx[backDirection];
                int ny = c + dy[backDirection];

                // 벽일 경우 종료
                if (graph[nx][ny] == 1) break;

                r = nx;
                c = ny;
            }
        }

        return count;
    }
}


class boj14503Ref2{

        static int N, M, r, c, d;
        static int[][] arr;
        static int count = 1; //시작 지점은 항상 청소되어 있지 않음
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};

        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 행 크기
            int m = Integer.parseInt(st.nextToken()); // 열 크기

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 로봇 초기 위치 (행)
            int c = Integer.parseInt(st.nextToken()); // 로봇 초기 위치 (열)
            int direction = Integer.parseInt(st.nextToken()); // 초기 방향

            arr = new int[N][M];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            clean(r, c, d);
            System.out.println(count);
        }

        public static void clean(int x, int y, int dir) {

            arr[x][y] = -1;

            for(int i = 0; i < 4; i++) {
                dir = (dir+3)%4;

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(arr[nx][ny] == 0) {
                        count++;
                        clean(nx, ny, dir);
                        return;
                    }
                }
            }

            int d = (dir + 2) % 4; //반대 방향으로 후진
            int bx = x + dx[d];
            int by = y + dy[d];
            if(bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
                clean(bx, by, dir); //후진이니까 바라보는 방향은 유지
            }
        }
    }



