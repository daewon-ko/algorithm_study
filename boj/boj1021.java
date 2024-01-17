package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // N
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int targetIndex = deque.indexOf(seq[i]);
            int halfIndex;

            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            }else{
                halfIndex = deque.size() / 2;
            }

            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    Integer temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }else{
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    Integer temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();

        }
        System.out.println(count);
    }
}
