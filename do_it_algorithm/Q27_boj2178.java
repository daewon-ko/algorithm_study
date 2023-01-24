package do_it_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q27_boj2178 {
    // 동서남북 방향 정의
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 2차원 배열 정의
    static int[][] A;
    static boolean[][] visited;
    // 행 숫자 정의
    static int n;
    // 열 숫자 정의
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(A[n - 1][m - 1]);

    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k = 0; k<4; k++){
                int x = now[0] +dx[k];
                int y = now[1] +dy[k];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(A[x][y] !=0 && !visited[x][y]){
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] +1;
                        queue.offer(new int[]{x,y});
                    }
                }

            }
        }
    }
}