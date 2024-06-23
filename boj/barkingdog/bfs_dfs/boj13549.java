
package boj.barkingdog.bfs_dfs;

import java.io.*;
import java.util.*;

// 백준 13549
public class boj13549 {
    static int n,k;
    static final int MAX = 100000 + 10;

    static boolean [] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX];

        bfs();
        System.out.println(min);




    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollX = poll.x;
            visited[pollX] = true;

            if (pollX == k) {
                min = Math.min(min, poll.time);
            }

            if((pollX*2) <MAX && !visited[pollX*2])
                queue.offer(new Node(pollX * 2, poll.time));
            if((pollX+1)<MAX && !visited[pollX+1])
                queue.offer(new Node(pollX + 1, poll.time + 1));
            if((pollX-1)>=0 && !visited[pollX-1])
                queue.offer(new Node(pollX - 1, poll.time + 1));
        }
    }

    static class Node{
        int x;
        int time;

        public Node(final int x, final int time) {
            this.x = x;
            this.time = time;
        }
    }



}
