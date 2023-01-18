package do_it_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 숫자배열 생성
        int [] A = new int[n];
        // 합배열 생성
        int sum = 0;
        int prev = 0;

        for(int i = 0 ; i<n; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        for(int i = 0; i<n; i++){
            sum+=prev+A[i];
            prev += A[i];
        }
        System.out.println(sum);



    }
}
