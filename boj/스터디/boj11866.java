package boj.스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 요세푸스 문제 0
public class boj11866 {
    static int n,k;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for (int i = 1; i <=n; i++) {
            queue.add(i);
        }

        sb.append("<");

        for (int i = 0; i < n-1; i++) {
            solve(queue);
            sb.append(", ");
        }
        sb.append(queue.poll());

        sb.append(">");

        System.out.println(sb.toString());


    }

    public static void solve(Queue<Integer> queue) {
        for (int i = 1; i < k; i++) {
            Integer poll = queue.poll();
            queue.add(poll);
        }

        // k번째 수 제거
        Integer k = queue.poll();

        sb.append(k );

    }
}
