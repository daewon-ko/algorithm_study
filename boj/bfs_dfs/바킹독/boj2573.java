package boj.bfs_dfs.바킹독;

// 백준 빙산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS로 풀어야겠다.
 * 1. 두 덩어리 이상으로 분리되는 '최소'의 시간을 구한다.
 * 2. 2차원 배열그래프로 입력이 주어진다.
 * 3. n,m의 MAX값은 300 -> 시간복잡도는 크게 중요하지 않을 것 같다.
 * 4. 동서남북 방향에 바다(0으로 입력된 값)이 존재하는 개수만큼 자기 자신에 영향이 간다.
 * 즉, 동서남북으로 이동했을때, inRange && graph[newY][newX] == '0' -> cnt++;
 * - inRange함수는 필요가 없지 않나? 문제의 조건 상 행열의 초기인덱스와 마지막인덱스는 0으로 주어진다.
 * 0이 아니면 Queue에 Offer한다. 동시에 Offer,graph[y][x]- cnt로 초기화한다. visited도 나중에 초기화한다.
 * 5. 각각의 Time에 Queue에 넣고 빼면서, BFS를 도는데, 섬의 개수가 2개일때 while문을 탈출한다.
 * 6. while문을 탈출하지 못하면 정답은 0이다.
 */
public class boj2573 {
    static int n, m;
    static final int MAX = 300 + 10;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    //    static int island_cnt;


    static class Node {
        int y;
        int x;

        public Node(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[MAX][MAX];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0) {
                    queue.offer(new Node(i, j));
                }
            }
        }


        int time = 0;
//        int island_cnt = 0;
        int cnt = 0;

        while (true) {
            int islandCnt = getIslandCnt();

            if (islandCnt >= 2) {
                System.out.println(time);
                return;
            } else if (islandCnt == 0) {
                System.out.println(0);
                return;
            }

            // bfs()는 연결되어있는 섬을 녹이는 기능을 수행한다.

            visited = new boolean[MAX][MAX];
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= m; j++) {
//                    if (!visited[i][j] && graph[i][j] > 0) {
//                        bfs(i, j);
//                    }
//                }
//            }

            bfs();

            time++;
        }
    }

    private static int getIslandCnt() {
        int island_cnt = 0;
        // 아래 DFS는 섬의 개수를 카운트한다.
        visited = new boolean[MAX][MAX];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && graph[i][j] > 0) {
                    DFS(i, j);
                    island_cnt++;

                }
            }
        }
        return island_cnt;
    }

    public static void DFS(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (graph[newY][newX] > 0 && inRange(newY, newX) && !visited[newY][newX]) {
                DFS(newY, newX);
            }
        }
    }

    public static void bfs() {
        int[][] newGraph = new int[MAX][MAX];


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int pollY = node.y;
            int pollX = node.x;


            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];


                if (inRange(newY, newX) && graph[newY][newX] == 0) {
                    cnt++;
                }
//                else if (graph[newY][newX] != 0) {
//                    queue.offer(new Node(newY, newX));
//                    visited[newY][newX] = true;
//                }

            }
            newGraph[node.y][node.x] = Math.max(graph[node.y][node.x] - cnt, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                graph[i][j] = newGraph[i][j];
                if (graph[i][j] > 0) {
                    queue.offer(new Node(i, j));
                }
            }
        }
    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= m;
    }
}
