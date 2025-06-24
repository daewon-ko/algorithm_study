package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String words = br.readLine();
            StringBuilder sb = new StringBuilder();
            String[] word = words.split(" ");

            for (int k = 0; k < word.length; k++) {
                String s = word[k];
                for (int j = s.length() - 1; j >= 0; j--) {
                    sb.append((s.charAt(j)));
                }
                sb.append(" ");
            }

            System.out.println(sb);

        }
    }
}
