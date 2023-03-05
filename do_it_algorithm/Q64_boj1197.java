package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 최소 신장 트리 구하기
/*
궁금한 것
1. while문의 횟수를 노드개수 -1로 설정해야하는 이유

 */
public class Q64_boj1197 {
    static int [] parent;
    static PriorityQueue<pEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<>();
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }


        // PriorityQueue를 통해 내부정렬(오름차순으로)
        // 최소신장트리 구하기 자체가 내부 값을 오름차순으로 정렬해야한다.
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queue.offer(new pEdge(s,e,v));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge <n-1){
            pEdge now = queue.poll();
            if(find(now.s) !=find(now.e)){
                union(now.s,now.e);
                result = result + now.v;
                useEdge++;
            }
        }

        System.out.println(result);




    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a){
        if (a == parent[a]) {
            return a;
        }else
            return parent[a] = find(parent[a]);
    }
    static class pEdge implements Comparable<pEdge>{
        int s;
        int e;
        int v;
        pEdge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(pEdge o) {
            return this.v - o.v;
        }
    }
}
