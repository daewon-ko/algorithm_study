import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer> graph[];
    static int [] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        answer = new int[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            BFS(i);
        }
        int maxVal = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            maxVal = Math.max(maxVal,answer[i]);
        }

        for(int i=1; i<=n; i++){
            if(answer[i] == maxVal){
                System.out.print(i+" ");
            }
        }


    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : graph[now_node]){
                if(!visited[i]){
                   visited[i] = true;
                   answer[i]++;
                   queue.offer(i);
                }
            }
        }
    }
}