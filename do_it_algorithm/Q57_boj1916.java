package do_it_algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//boj 1916 최소비용 구하기
public class Q57_boj1916 {
    static int n,m;
    static ArrayList<ArrayList<Node2>> list;
    static int [] dis;
    static boolean [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dis = new int[n+1];
//        check = new boolean[n+1];

        Arrays.fill(dis,Integer.MAX_VALUE);

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        // 단방향 인접리스트 구현
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weigt = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node2(end, weigt));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startPoint, endPoint)+ "\n");
        bw.flush();
        bw.close();
        br.close();

    }
    // 다익스트라 알고리즘
    static int dijkstra(int start, int end){
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        boolean []  check = new boolean[n+1];
        pq.offer(new Node2(start,0));
        dis[start ] = 0;
        while (!pq.isEmpty()){
            Node2 curNode = pq.poll();
            int cur = curNode.end;

            if(!check[cur]){
                check[cur] = true;

                for(Node2 node : list.get(cur)){
                    if(!check[node.end] && dis[node.end] > dis[cur] + node.weight){
                        dis[node.end] = dis[cur] + node.weight;
                        pq.add(new Node2(node.end, dis[node.end]));
                    }
                }
            }
        }
        return dis[end];
    }

}

class Node2 implements Comparable<Node2>{
    int end;
    int weight;

    Node2(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    /*
    compareTO 메서드 : 인자로 넘어온 같은 타입의 다른 객체와 대소 비교 가능
    메서드를 호출하는 객체가 인자로 넘어온 객체보다
    작을 경우에는 음수를 리턴하고,
    크기가 동일하다면 0
    클 경우에는 양수를 리턴
     */
    @Override
    public int compareTo(Node2 o) {
        return weight - o.weight;
    }
}
