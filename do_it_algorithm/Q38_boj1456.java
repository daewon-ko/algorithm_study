package do_it_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 거의 소수 구하기
/*
이항정리 부분이 이해가 가지 않는다. 일단ㄴ은 암기하는 걸로..
 */
public class Q38_boj1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 10의 14승의 절반이 10의7승. 해당숫자만큼을 숫자 구역으로 범위를 획정
        long [] A = new long[10000001];
        for(int i=2; i<A.length; i++){
            A[i] = i;
        }
        for(int i = 2; i<Math.sqrt(A.length); i++){
            if(A[i]==0){
                continue;
            }
            for(int j= i+i; j<A.length; j+=i){
                A[j] = 0;
            }
        }

        int cnt = 0;
        for(int i= 2; i<A.length; i++){
            if(A[i] !=0){
                long temp = A[i];
                while ((double)A[i]<= (double) max/(double) temp){
                    if((double)A[i]>=(double) min/(double) temp){
                        cnt++;
                    }
                    temp = temp*A[i];
                }
            }
        }
        System.out.println(cnt);
    }
}
