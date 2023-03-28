package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q84_boj1463 {
    static int n;
    static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1]= 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if(i%2==0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if(i%3==0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }
        System.out.println(d[n]);


    }
}
