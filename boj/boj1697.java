package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 숨바꼭질
public class boj1697 {
    static int n, k;
    static final int MAX = 100000 + 10;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int next = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX];
        queue.offer(n);
        visited[n] = true;

        int result = bfs();

        System.out.println(result);

        br.close();
    }

    public static int bfs() {

        int[] time = new int[MAX];

        while (!queue.isEmpty()) {
            int pollNumber = queue.poll();

            if (pollNumber == k) {
                return time[pollNumber];
            }

            for (int i = 0; i < 3; i++) {

                if (i == 0) {
                    next = pollNumber - 1;
                } else if (i == 1) {
                    next = pollNumber + 1;
                } else {
                    next = pollNumber * 2;
                }


                if (isRange(next) && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    time[next] = time[pollNumber] +1;

                }

            }

        }
        return -1;
    }

    public static boolean isRange(int number) {
        return number >= 0 && number <= 100000;
    }
}
