package boj;


import java.io.*;
import java.util.*;
/**
 * 백준 촌수계산
 *
 *
 * 포인트 :
 * 1. count 매개변수
 * 2.매개변수의 인덱스에서 count++, count+1의 차이
 *
 */
public class boj2644 {
    static int n,m;
    static final int MAX = 100 +10;

    static int answer;

    static boolean [] visited;
    static boolean [][] graph;

    static int start, end;

    public static void dfs(int index, int count) {
        visited[index] = true;

        if (index == end) {
            answer = count;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i] && graph[index][i]) {
                dfs(i, count+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        answer = -1;
        visited = new boolean[MAX];
        graph = new boolean[MAX][MAX];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(start, 0);


        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
