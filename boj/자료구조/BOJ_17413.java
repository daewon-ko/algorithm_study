package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class BOJ_17413 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            int index = 0;

            while (index < line.length()) {
                if (line.charAt(index) == '<') {
                    while (true) {
                        sb.append(line.charAt(index++));
                        if (line.charAt(index) == '>') {
                            sb.append(line.charAt(index++));
                            break;
                        }

                    }
                } else if (line.charAt(index) == ' ') {
                    sb.append(" ");
                    index++;
                } else {
                    while (index < line.length() && line.charAt(index) != ' ' && line.charAt(index) != '<') {
                        stack.push(line.charAt(index++));
                    }

                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
            }

            System.out.println(sb);

        }

    }

