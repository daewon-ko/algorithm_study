package boj.스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 설탕 배달
public class boj2839First {
    static int n;
    static int fiveCount = 0;
    static int threeCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (n  != (5 * fiveCount + 3 * threeCount) ) {

            if (5 * fiveCount > n) {
                fiveCount--;
                threeCount++;
            }

//            if(5* fiveCount + 3* threeCount> n){
//                System.out.println(-1);
//                return;
//            }

            if(5* fiveCount + 3* threeCount < n){
                fiveCount++;
            }
        }

        System.out.println(fiveCount + threeCount);





    }
}


class boj2838Re{
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());


        int fiveCount = n / 5;
        while (fiveCount >= 0) {
            int remainder = n - (fiveCount * 5);
            if (remainder % 3 == 0) {
                int threeCount = remainder/3;
                System.out.println(fiveCount + threeCount);
                return;
            }
            fiveCount--;
        }

        System.out.println(-1);



    }
}
