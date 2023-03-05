package do_it_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 불우이웃돕기
public class Q66_boj1414 {
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
                if(tempc[j]>='a' && tempc[j]<='z'){
                    /*
                    temp += tempc[j] -'a'+1;
                    이렇게 선언과 무엇이 다르지?
                    어차피 이중 For문 내의 temp를 계속해서 0으로 초기화해주지 않나?
                     */
//                    temp+= (tempc[j] -'a'+1);
                    temp = tempc[j] -'a'+1;
                } else if (tempc[j] >= 'A' && tempc[j] <= 'Z') {
//                    temp += (tempc[j] - 'A'+1);
                    temp = tempc[j] -'A'+27;
                }


                sum+= temp;
                if(i != j && temp != 0){
                    queue.offer(new lEdge(i,j, temp));
                }
            }
        }

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()){
            lEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if(useEdge == n-1){
            System.out.println(sum -result);
        }else{
            System.out.println(-1);
        }


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

    /*
    union과 find 연산은 그냥 외우자.
     */
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;

    }

    static int find(int a){
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);

    }
}
