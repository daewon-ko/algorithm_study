package do_it_algorithm;

import java.util.Scanner;

// BOJ 2750
public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int[n];

        for(int i = 0; i<n; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i<n-1; i++){
            for(int j= 0; j<n-1; j++){
                if(A[j] >A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
        for(int i = 0; i<n; i++){
            System.out.println(A[i]);
        }
    }
}
