package programmers.level2;

import java.util.Stack;

public class 올바른괄호 {
//    boolean solution(String s) {
//        boolean answer = true;
//        StringBuilder sb = new StringBuilder();
//
////        boolean isClose = true;
//
//        for (int i = 0; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//            if (String.valueOf(s.charAt(i)).equals("(")) {
////                isClose = false;
//            } else {
//
//                if (sb.substring(0, sb.length()).contains("(")) {
//
//                    sb.deleteCharAt(i);
//                }
//
//            }
//
//        }
//
//        if (sb.length() == 0) {
//            return answer;
//        }else {
//            answer = false;
//            return answer;
//        }
//
//
//    }

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
