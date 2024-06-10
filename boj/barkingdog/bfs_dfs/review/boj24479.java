package boj.barkingdog.bfs_dfs.review;

import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 가중치 라는 말이 눈에 띈다.
 *
 * 시간복잡도 때문에 List<List<Integer>> 형태로 작성해야하지만 편하게 작성하기 쉽지 않다.
 * 2차원 배열 형태의 배열에서는 노드와 노드를 2차원 배열의 각 인덱스에 적절하게 넣어주면 되지만 List<List<>> 형태는 쉽게 떠오르지 않는다.
 */
public class boj24479 {
    static int n,m,r;
    static final int MAX = 100000 + 10;

    static List<Integer> [] graph;

    static boolean [] visited;
    static int order;
    static int [] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX];


        graph = new ArrayList[MAX];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        answer = new int[MAX];

        order =1;



        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }


        // graph 배열의 element 초기화 -> 오름차순위해
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int index) {
        visited[index] = true;
        answer[index] = order;
        order++;

        for (int i = 0; i < graph[index].size(); i++) {
            int next = graph[index].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }



    }
}
