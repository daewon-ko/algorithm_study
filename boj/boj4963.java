package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 섬의 개수
public class boj4963 {
    static final int MAX = 50;
    static int [] dx = new int[]{0,-1,-1,-1,0,1,1,1};
    static int [] dy = new int []{1,1,0,-1,-1,-1,0,1};
    static int [][] graph;

    static int w;
    static int h;

    public static void dfs(int x, int y){

            graph[x][y] = 0;

        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(inRange(nx,ny) && graph[nx][ny]==1) {
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w =Integer.parseInt(st.nextToken());
            h =Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }
            graph = new int[MAX][MAX];

            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(graph[i][j]==1){
                        dfs(i,j);
                        answer++;
                    }


                }
            }
            System.out.println(answer);

        }


    }

    public  static boolean inRange(int x, int y){
        return x>=1 && x<=h && y>=1 && y<=w;
    }
}
