package do_it_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29_boj1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int wanted = Integer.parseInt(st.nextToken());
            boolean find = false;
            // 인덱스 번호 스타트 0
            int start = 0;
            // 인덱스 번호 마지막 배열 크기 -1
            int end = A.length-1;

            while (start<=end){
                int mid = (start+end)/2;
                int mid_value = A[mid];
                if(wanted<mid_value){
                    end = mid -1;
                }
                else if(wanted>mid_value){
                    start = mid+1;
                }
                find = true;
                break;
            }

            if(find){
                System.out.println(1);
            } else{
                System.out.println(0);
            }

        }

    }
}
