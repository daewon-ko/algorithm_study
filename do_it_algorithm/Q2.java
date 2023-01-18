package do_it_algorithm;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] A = new long[n];

        for(int i =0; i<n; i++){
            A[i] =sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int i = 0; i<n; i++){
            if(A[i]>max) max = A[i];
            sum+= A[i];
        }
        System.out.println(sum*100.0/max/n);

    }
}
