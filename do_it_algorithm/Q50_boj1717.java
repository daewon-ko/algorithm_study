package do_it_algorithm;

import java.io.*;
import java.util.StringTokenizer;

// 백준 1717번 집합의 표현
public class Q50_boj1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 부모를 찾는 메서드
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // Union하는 메서드
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // union의 연산은 기본적으로 부모값을 찾은 다음,
        // 더 작은 것으로 교체하는 개념
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
    public static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return true;
        }
        return false;
    }
}
