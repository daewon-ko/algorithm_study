import java.io.*;
import java.util.StringTokenizer;

// 두잇자바 37번_boj1456_거의 소수 구하기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int [] A = new int [n+1];

        for(int i= 2; i<=n; i++){
            A[i] = i;
        }

        for(int i = 2; i<=Math.sqrt(n); i++){
            if(A[i] ==0 ){
                continue;
            }
            for(int j = 2*i; j<=n; j=i+j){
                A[j] = 0;
            }
        }

        for(int i = m; i<=n; i++){
            if(A[i] != 0){
                System.out.println(A[i]);
            }
        }


    }
}