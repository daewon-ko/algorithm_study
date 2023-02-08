import java.util.*;
import java.io.*;


// 39번
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long result = gcd(a,b);
        while(result>0){
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();

    }
    static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}