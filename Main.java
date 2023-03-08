import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;

public class Main {
    static int n, sum;
    static int[] parent;
    static PriorityQueue<lEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
                int temp = 0;
                if (tempc[j] >= 'a' && tempc[j] <='z') {
                    temp = tempc[j] - 'a' + 1;
                } else if (tempc[j] >= 'A' && tempc[j] <= 'Z') {
                    temp = tempc[j] - 'A' + 27;
                }
                sum += temp;
                if (i != j && temp != 0) {
                    queue.offer(new lEdge(i, j, temp));
                }
            }
        }

          parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] =i;
        }

//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }

        int useEdge = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            lEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        if (useEdge == n - 1) {
            System.out.println(sum - result);
        } else {
            System.out.println(-1);
        }

    }


    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }


    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
       return parent[a] = find(parent[a]);
    }

    static class lEdge implements Comparable<lEdge> {
        int s, e, v;

        public lEdge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(lEdge o) {
            return this.v - o.v;
        }
    }
}