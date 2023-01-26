package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 개수의 최솟값 구하기
public class Q32_boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] coin = new int [n];
        for(int i= 0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = n-1; i>=0; i--){
            if(coin[i]<=k){
                cnt += (k/coin[i]);
                k = k%coin[i];
            }
        }
        System.out.println(cnt);


    }
}
