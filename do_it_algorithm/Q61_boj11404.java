package do_it_algorithm;


import java.io.*;
import java.util.StringTokenizer;

// 백준 11404번 가장 빠른 버스 노선 구하기
/*
의문 distance[i][j]를 Integer.MaxValue로 하면 안되는 이유는?
 */
public class Q61_boj11404 {
    static long [][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        distance = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (distance[start][end] > cost) distance[start][end] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(distance[i][j]> distance[i][k]+ distance[k][j])
                        distance[i][j] = distance[i][k]+distance[k][j];

//                    distance[i][j] = Math.max(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

}
