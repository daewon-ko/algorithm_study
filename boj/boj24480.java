package boj;

import java.util.*;
import java.io.*;

// 백준 알고리즘 수업- 깊이우선 탐색2

/**
 * n의 크기가 최대 100,000이기에 2차원배열의 자료구조를 생성 시에 십억이 필요
 * 시간제한이 1초(1억 내에 연산이 필요) 초과한다.
 * 따라서 ArrayList, List와 같은 동적으로 할당하는 자료구조를 생성이 필요하다.
 *
 * 항상 겪는 문제지만, 배열의 인덱스 설정 등의 문제는 신중이 필요하다.
 * 배열의 인덱스 등을 잘못 설정하여 IndexOutOfBound 등의 에러가 발생하니 꼼꼼히 확인 필요.
 */
public class boj24480 {
    static final int MAX = 1000000+10;
    static int n,m,v;
    static int order;
    static boolean [] visited;
    static int answer [];

    static List<Integer>[] graph;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt((st.nextToken()));
        m = Integer.parseInt((st.nextToken()));
        v = Integer.parseInt((st.nextToken()));

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder() );
        }

        dfs(v);

        for (int i = 1; i <= n; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
