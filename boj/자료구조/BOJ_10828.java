package boj.자료구조;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                String number = st.nextToken();
                stack.push(number);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                }else{
                    String pop = stack.pop();
                    System.out.println(pop);
                }
            } else if (command.equals("size")) {
                int size = stack.size();
                System.out.println(size);
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }

        }
    }
}
