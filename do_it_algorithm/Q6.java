package do_it_algorithm;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        int sum = 1;
        int end = 1;
        int start = 1;
        while (end!= n){
            if(sum == n){
                cnt++;
                end++;
                sum += end;

            }else if(sum>n){
                sum = sum - start;
                start++;

            }else{
                end++;
                sum += end;
            }

        }
        System.out.println(cnt);


    }
}
