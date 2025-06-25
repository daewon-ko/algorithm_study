package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9012 {
    static int t;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            System.out.println(isValid(s) ? "YES" : "NO");
        }

    }
    public static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c=='('){
                count++;
            }else{
                count--;
            }

            if(count<0) return false;
        }

        return count == 0;
    }
}
