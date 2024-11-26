package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 백준 감시
public class boj15683 {


}


class boj15683Ref{

    static int n,m;
    static int [][] graph;
    static List<CCTV> cctvList = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;

    static int [][] move = {
            {0,1},
            {-1,0},
            {0,-1},
            {1,0}
    };

    static int [][] cctvDir ={
            {},
            {0},
            {0,2},
            {0,1},
            {0,1,2},
            {0,1,2,3}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    cctvList.add(new CCTV(i,j, graph[i][j]));
                }
            }
        }

        dfs(0, graph);
        System.out.println(MIN);


    }
    public static void dfs(int cctvIdx, int[][] graph) {

        if (cctvIdx == cctvList.size()) {
            MIN = Math.min(MIN, count(graph));
            return;
        }


        CCTV cctv = cctvList.get(cctvIdx);

        int y = cctv.y;
        int x = cctv.x;
        int number = cctv.number;


        for (int i = 0; i < 4; i++) {
            int[][] cMap = copyMap(graph);
            for (int d : cctvDir[number]) {
                d = (d + i) % 4;
                int newY = y;
                int newX = x;
                while (true) {
                    newY += move[d][0];
                    newX += move[d][1];
                    if(newY<0 || newX<0 || newY>=n || newX>=m || graph[newY][newX] == 6) {
                        break;
                    }
                    cMap[newY][newX] = -1;
                }
            }
            dfs(cctvIdx + 1, cMap);


        }





    }

    public static int[][] copyMap(int[][] graph) {

        int[][] cMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cMap[i][j] = graph[i][j];
            }
        }
        return cMap;
    }

    public static int count(int[][] graph) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class CCTV{
        int y;
        int x;
        int number;

        public CCTV(int y, int x, int number) {
            this.y = y;
            this.x = x;
            this.number = number;
        }
    }
}