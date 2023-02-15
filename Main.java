import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static List<Integer> graph[];
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new int[n+1];
        answer = new ArrayList<>();

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            visited[i] = -1;
        }
        // 각 노드와 노드 사이에 에지를 추가
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        // BFS 시행
        BFS(x);

        for(int i=1; i<=n; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int temp : answer){
                System.out.println(temp);
            }
        }

    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node]++;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : graph[now_node]){
                if(visited[i] == -1){
                    visited[i] = visited[now_node]+1;
                    queue.offer(i);
                }
            }
        }
    }
}