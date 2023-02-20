package do_it_algorithm;


import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1976번 여행계획짜기
public class Q51_boj1976 {
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] dosi = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dosi[i][j] = Integer.parseInt(br.readLine());
            }
        }

        int[] route = new int[m+1];
        for(int i=1; i<=m; i++){
            route[i] = Integer.parseInt(br.readLine());
        }
        parent = new int[n+1];
        // 대표 노드를 자기 자신으로 초기화
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dosi[i][j]==1) union(i,j);
            }
        }

        int index = find(route[1]);

        for(int i=2; i<route.length; i++){
            if(index != find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            parent[b] = a;
        }
    }
    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

}

