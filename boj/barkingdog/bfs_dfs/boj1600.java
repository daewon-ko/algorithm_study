package boj.barkingdog.bfs_dfs;

/**
 * 백준 1600 말이되고픈 원숭이
 * 기존의 bfs 문제(경로 최솟값 구하기) + 나이트 이동방향을 추가했다.
 * 나이트의 이동방향은 bfs 함수 내에서 k번만큼 반복한다.
 * 일반 이동방향은 4ㅂ회 반복문
 */

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1600 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dx_knight = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy_knight = {2, 1, -1, -2, -2, -1, 1, 2};
    static int k, w, h;
    static final int MAX = 200 + 10;
    static int[][] graph;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX];
        visited = new boolean[MAX][MAX][MAX];

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // graph의 초기값이 0이므로 서로 위치값을 변환해준다.
                // 즉 0이면 장애물이고, 1이어야 이동가능하게끔
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                } else if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                }
            }
        }

        bfs(1, 1);

        System.out.println(answer);

    }

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x, 0, 0));
        visited[y][x][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y == h && node.x == w) {
                answer = Math.min(answer, node.cnt);
                return;
            }




            for (int i = 0; i < 4; i++) {
                int newY = dy[i] + node.y;
                int newX = dx[i] + node.x;
                if (inRange(newY, newX) && !visited[newY][newX][node.knightCnt] && graph[newY][newX] == 1) {
                    queue.offer(new Node(newY, newX, node.cnt + 1, node.knightCnt));
                    visited[newY][newX][node.knightCnt] = true;
                }
            }


            // 로직 수정 필요
            /**
             * 나이트의 이동방향은 k번까지만 Queue에 삽입가능하다.
             * 그러나, Queue에 어느 시점에 삽입하느냐에 따라서 이동횟수가 달라질 수 있다.
             * 지금처럼, While문 초기에서 k와 knigh_cnt를 비교하면 로직 초기에 바로 Queue에 삽입할 수 있으며,
             * 이는 문제에서 요구하는 최소값(최소시간)을 구하는 것과 약간 차이가 있다.
             * 어떻게 해결할 수 있을까?
             */

            if (node.knightCnt < k) {

                for (int j = 0; j < 8; j++) {
                    int newY = node.y + dy_knight[j];
                    int newX = node.x + dx_knight[j];

                    if (inRange(newY, newX) && !visited[newY][newX][node.knightCnt+1] && graph[newY][newX] == 1) {
                        queue.offer(new Node(newY, newX, node.cnt + 1, node.knightCnt + 1));
                        visited[newY][newX][node.knightCnt + 1] = true;
//                        break;
                    }
                }
            }

        }
        answer = -1;

    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && y < MAX && x >= 1 && x < MAX;
    }

    static class Node {
        int y;
        int x;
        int cnt;
        int knightCnt;

        Node(int y, int x, int cnt, int knightCnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.knightCnt = knightCnt;
        }
    }
}
