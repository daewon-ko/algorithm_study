package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 특정거리의 도시 찾기 문제
public class Q46_boj18352 {
    static int visited[];
    static ArrayList<Integer>[] graph;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n,m,k,x 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }

        BFS(x);
        // visited[i]의 값이 k일때, answer에 해당 노드를 추가.
        for(int i=1; i<=n; i++){
            if(visited[i] ==k){
                answer.add(i);
            }
        }
        // 리스트가 비어있을 경우 -1 출력
        if(answer.isEmpty()){
            System.out.println("-1");
        }
        // 리스트를 오름차순으로 정렬 후 요소 출력
        else{
            Collections.sort(answer);
            for(int temp : answer){
                System.out.println(temp);
            }
        }



    }
    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node]++;
    while (!queue.isEmpty()){
        int now_node = queue.poll();
        for(int i : graph[now_node]){
            if(visited[i] == -1){
                visited[i] = visited[now_node]+1;
                queue.add(i);
            }
        }
    }
    }
}
