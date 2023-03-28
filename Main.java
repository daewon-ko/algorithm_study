import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = 1000000000;
        long d[] = new long[1000001];
        d[1] = 0;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (i - 1)* (d[i - 1] + d[i - 2]) / mod;
        }
        System.out.println(d[n]);
    }
}
