package boj.bfs_dfs.바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 불!
public class boj4179 {
    static int r,c; // r은 세로, c는 가
    static final int MAX = 1000 +10;
    static char [][] graph;
    static boolean[][] visitedPerson;
    static boolean[][] visitedFire;
    static Queue<Exit> queue = new LinkedList<>();

    static boolean flag = false;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Exit{
        // y,x -> 좌표, cnt -> 이동횟수
        char c;
        int y;
        int x;
        int cnt;

        public Exit(final char c, final int y, final int x, final int cnt) {
            this.c = c;
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[MAX][MAX];
        visitedPerson = new boolean[MAX][MAX];
        visitedFire = new boolean[MAX][MAX];


        for (int i = 1; i <= r; i++) {
            String line = br.readLine();
            for (int j = 1; j <= c; j++) {
                graph[i][j] = (line.charAt(j - 1));
                if (graph[i][j] == 'J') {
                    queue.offer(new Exit('J',i, j, 0));
                } else if (graph[i][j] == 'F') {
                    queue.offer(new Exit('F', i, j, 0));
                }

            }
        }

        int result = bfs();
        if (flag) {
            System.out.println(result+1);

        }else{
            System.out.println("IMPOSSIBLE");

        }


    }
    public static int bfs() {

        int result = 0;

        while (!queue.isEmpty()) {
            Exit poll = queue.poll();
            char pollChar = poll.c;
            int pollY = poll.y;
            int pollX = poll.x;
            result = poll.cnt;

            if (pollChar == 'J' && pollY == r || pollX == c) {
                flag = true;
                break;
//                return result;
            }


            if (pollChar == 'J') { // 사람이라면
                for (int i = 0; i < 4; i++) {
                    int newY = pollY + dy[i];
                    int newX = pollX + dx[i];
                    if (isRange(newY, newX) && !visitedPerson[newY][newX] && !visitedFire[newY][newX] && graph[newY][newX] == '.') {
                        queue.offer(new Exit('J', newY, newX, result + 1));
                    }
                }
            } else if (pollChar == 'F') {   // 불길이라면
                for (int i = 0; i < 4; i++) {
                    int newY = pollY + dy[i];
                    int newX = pollX + dx[i];
                    if (isRange(newY, newX) && !visitedFire[newY][newX] && graph[newY][newX] == '.') {
                        queue.offer(new Exit('F', newY, newX, result + 1));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isRange(final int newY, final int newX) {
        return newY >= 1 && newY <= r && newX >= 1 && newX <= c;
    }
}
