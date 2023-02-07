package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 공배수 구하기
public class Q42_boj1934 {
    public static void main(String[] args) throws IOException {
        // 유클리드 호제법(최대공약수)을 이용한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int result = a*b /gcd(a,b);
            System.out.println(result);
        }
    }
    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        // 재귀함수
        return gcd(b,a%b);
    }
}
