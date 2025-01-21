package programmers.highScoreKit;//package programmers.highScoreKit;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
////프로그래머스 네트워크문제
//public class Network {
//
//    class Solution {
//        static boolean[] visited;
//        static List<Integer> graph [];
//        //        static int group;
//        static int answer;
//
//        public int solution(int n, int[][] computers) {
//            answer = 0;
//            visited = new boolean[n+1];
//            graph = new ArrayList [n+1];
////            group = n;
//
//            for(int i=1; i<=n; i++){
//                graph[i] = new ArrayList<>();
//            }
//
//
//            // n =computers.length인셈.
//
//
//            for(int i=1; i<=n; i++){
//                for(int j=1; j<=n; j++){
//                    if(computers[i-1][j-1] ==1){
//                        graph[i].add(j);
//                    }
//                }
//            }
//
//            for(int i=1; i<=n; i++){
//                if(!visited[i]){
//                    BFS(i);
//                    answer++;
//                }
//            }
//
////            answer = group;
//
//            return answer;
//        }
//
//        static void BFS(int node) {
//            Queue<Integer> queue = new LinkedList<>();
//            queue.offer(node);
//            visited[node] = true;
//            while (!queue.isEmpty()){
//                int now_node = queue.poll();
//                for(int next : graph[now_node]){
//                    if(!visited[next]){
//                        visited[next] = true;
////                        group--;
//                        queue.offer(next);
//                    }
//
//                }
//            }
//        }
//    }
//}
