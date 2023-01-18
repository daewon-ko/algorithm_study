package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 친구 관계 파악하기
public class Q25_boj13023 {
    private static ArrayList<Integer> []  list;
    private static boolean [] v;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // DFS를 위한 인접리스트 구현
        list = new ArrayList[n];
        v = new boolean[n];

        for(int i = 0; i<n; i++){
            list[i] = new ArrayList<>();
        }


        // 각 노드와 간선을 추가(인접리스트끼리 간선을 연결하는 것을 구현한 코드)
        for(int i = 0 ; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        for(int i =0; i<n; i++){
            if(answer == 0)
                DFS(i,1);
        }
        System.out.println(answer);
    }
    private static void DFS(int start, int depth){
        // depth가 5이면 answer값이 1로 바뀌고 함수가 끝남
        if(depth==5) {
            answer = 1;
            return;
        }
        // 위의 조건을 충족못할 시, 해당 start 인덱스의 boolean 배열이 True로 변환
        v[start] = true;

        // list[start]가 가지고 있는 인접리스트(노드들)을 탐색
         for(int i : list[start]){
             // 해당 노드를 아직 탐색하지 않았을 시
            if(!v[i]){
                // DFS로 깊이우선 탐색 진행
                DFS(i,depth+1);
            }
        }
         // 위의 조건들을 모두 통과하지 못했을 시 boolean 배열의 t/f값을 원복
        // <- Boolean 배열 v가 static으로 선언했기 떄문
        v[start] = false;
    }
}
