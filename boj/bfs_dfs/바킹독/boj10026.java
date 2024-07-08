package boj.bfs_dfs.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 적록색약

// BFS,DFS 둘 방법 모두 가능하지 않을까?
public class boj10026 {
    static int n;
    static final int MAX = 100 + 10;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int cnt = 0;
    static int cnt_no_distinguish = 0;

    static class Color {
        int y;
        int x;

        public Color(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                graph[i][j] = line.charAt(j - 1);
            }
        }


        // 정상 시각
        Character[] normal = {'R', 'B', 'G'};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, normal);
                    cnt++;
                }
            }
        }

        // 방문배열 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                visited[i][j] = false;
            }
        }

        // 적록색약
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(!visited[i][j] ){
                    bfsNoDistinguish(i, j, normal);
                    cnt_no_distinguish++;

                }
            }
        }

        System.out.println(cnt+" "+cnt_no_distinguish);


    }

    // i,j는 시작점
    public static void bfs(int i, int j, Character[] normal) {

        Queue<Color> queue = new LinkedList<>();
        queue.offer(new Color(i, j));

        while (!queue.isEmpty()) {
            Color poll = queue.poll();
            int pollY = poll.y;
            int pollX = poll.x;

            for (int dir = 0; dir < 4; dir++) {
                int newY = pollY + dy[dir];
                int newX = pollX + dx[dir];

                    if (isRange(newY, newX) && graph[newY][newX] == graph[pollY][pollX] && !visited[newY][newX]) {
                        queue.offer(new Color(newY, newX));
                        visited[newY][newX] = true;
                    }

            }

        }
    }

        public static void bfsNoDistinguish(int i, int j, Character[] normal) {

            Queue<Color> queue = new LinkedList<>();
            queue.offer(new Color(i, j));
            visited[i][j] = true;

            while (!queue.isEmpty()) {
                Color poll = queue.poll();
                int pollY = poll.y;
                int pollX = poll.x;

                for (int dir = 0; dir < 4; dir++) {
                    int newY = pollY + dy[dir];
                    int newX = pollX + dx[dir];

                        char charNew = graph[newY][newX];
                        char charBefore = graph[pollY][pollX];
                        if (!visited[newY][newX] && noDistinguish(charNew, charBefore) && isRange(newY, newX) || (charNew == charBefore)) {
                            queue.offer(new Color(newY, newX));
                            visited[newY][newX] = true;
                        }

                }

            }

    }



    public static boolean noDistinguish(char graphNew, char graphBefore) {
        if ((graphBefore == 'G' || graphBefore == 'R') && (graphNew == 'G' || graphNew == 'R')) {
            return true;
        } else if (graphNew == graphBefore) {
            return true;
        }
        return false;
    }

    private static boolean isRange(final int newY, final int newX) {
        return newY >= 1 && newY < MAX && newX >= 1 && newX < MAX;
    }


}
