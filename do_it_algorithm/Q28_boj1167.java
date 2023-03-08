package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28_boj1167 {
    static boolean[] visited;
    static ArrayList<Node>[] A;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        // 이유를 모르겠으나 while문 내부를 빠져나오지 못하는 듯함.
        // 디버거를 돌려도 이유를 모르겠음
        for (int i = 0; i <n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                int edge = Integer.parseInt(st.nextToken());
                if (edge == -1)
                break;
                A[start].add(new Node(node, edge));
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1);
        int max = 1;
        for(int i =2; i<=n; i++){
            if(distance[max]<distance[i]){
                max = i;
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);


    }
    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(Node i : A[now_node]){
                int s = i.e;
                int v = i.value;
                if(!visited[s]){
                    queue.offer(s);
                    distance[s] = distance[now_node]+v;
                }
            }
        }
    }

}

class Node {
    public int weight;
    int e;
    int value;

    Node(int s, int v) {
        this.e = s;
        this.value = v;
    }
}
