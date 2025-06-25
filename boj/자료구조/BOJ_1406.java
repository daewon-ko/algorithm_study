package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406 {
    static Stack<String> leftCursor = new Stack<>();
    static Stack<String> rightCursor = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            leftCursor.push(String.valueOf(word.charAt(i)));
        }

        int m = Integer.parseInt(br.readLine());


        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            if (st.nextToken().equals("P")) {
                String alphabet = st.nextToken();
//                String popWord = leftCursor.pop();
                leftCursor.push(alphabet);
//                rightCursor.push(popWord);
            }

            // P명령어를 제외한 커맨드들
            else if (s.equals("L")) {
                if (!leftCursor.isEmpty()) {
                    String popWord = leftCursor.pop();
                    rightCursor.push(popWord);
                }
            } else if (s.equals("D")) {
                if (!rightCursor.isEmpty()) {
                    leftCursor.push(rightCursor.pop());
                }
            } else if (s.equals("B")) {
                if (!leftCursor.isEmpty()) {
                    leftCursor.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftCursor.isEmpty()) {
            sb.append(leftCursor.pop());
        }
        sb.reverse();

        while (!rightCursor.isEmpty()) {
            sb.append(rightCursor.pop());
        }

        System.out.println(sb);

    }
}
