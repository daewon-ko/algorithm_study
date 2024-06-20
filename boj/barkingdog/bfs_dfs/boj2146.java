package boj.barkingdog.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS를 (어디서?) 수행한다. -> 말단의 좌표를 찾는다.
 * 말단이라 함은 y,x값이 dx, dy로 newY, newX로 이동하는 값이 '처음으로' 1이 아닌 것을 만나는 곳이다.
 * 해당 좌표를 Queue에 모두 삽입한다.
 * 어디서? -> 섬에서(값이 1인 곳에서).
 * 값이 1인 곳 모두를 찾아서 전부 DFS를 돈다?
 * <p>
 * 해당 말단에서 BFS를 수행한다.
 * newY, newX(dx, dy에 따라 이동한 좌표값)가 graph[][]값이 0이고 inRange()안에 들어오면 Queue에 추가한다.
 * Queue에 추가할때마다 cnt변수도 같이 넣어준다?
 * pollY, pollX가 1을 만나면 반복문을 탈출한다.
 * Queue에 삽입되어있는 값들 중에 최소값을 찾는다. cnt =  Math.min(()함수값, cnt) 와 같은 형식으로 초기화?
 */
public class boj2146 {
    static int n;
    static final int MAX = 100 + 10;
    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] visitedForQueue;
    static int min = Integer.MAX_VALUE;

    static class Node {
        int y;
        int x;
        int cnt;

        public Node(final int y, final int x, final int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static Queue<Node> queue = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j])
                    visitedForQueue = new boolean[MAX][MAX];
                    dfs(i, j);
            }
        }

        bfs();

        System.out.println(min);


    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollY = poll.y;
            int pollX = poll.x;
            int cnt = poll.cnt;


            for (int i = 0; i < 4; i++) {
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];

                if (inRange(newY, newX) && graph[newY][newX] == 1) {
                    min = Math.min(min, cnt);
                }

                if (inRange(newY, newX) && graph[newY][newX] == 0) {
                    queue.offer(new Node(newY, newX, cnt + 1));
                }
            }
        }

    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (inRange(newY, newX) && graph[newY][newX] == 0 && !visitedForQueue[newY][newX]) {
                queue.offer(new Node(y, x, 0));
                visitedForQueue[y][x] = true;
            }
            if (inRange(newY, newX) && graph[newY][newX] == 1 && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }

    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
    }
}
