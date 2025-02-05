package boj.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(start, end));
        }

        int cnt =0;
        int endTime = 0;
        while (!pq.isEmpty()) {

            Lecture poll = pq.poll();

            if (endTime <= poll.start) {
                cnt++;
                endTime = poll.end;
            }



//            while (!pq.isEmpty() && pq.peek().start >= endTime) {
//                cnt++;
//                endTime = pq.poll().end;
//
//            }
        }

        System.out.println(cnt);

    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;


        public Lecture(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture other) {

            if (this.end != other.end) {
                return this.end - other.end;
            } else {
                return this.start - other.start;
            }
        }
    }

}
