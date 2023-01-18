package do_it_algorithm;

import java.util.Scanner;
import java.util.Stack;

// BOJ 1874번
/*
전반적으로 이해가 가지 않는다. 다시 한 번 확인해봐야겠다.
 */
public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int[N];
        for(int i =0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;

        for(int i = 0; i<A.length; i++){
            int su = A[i];
            if(su>=num){
                while (su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                // 자신을 출력하기 위한 Pop
                stack.pop();
                bf.append("-\n");
            }
            else{
                int n = stack.pop();

                if(n>su){
                    System.out.println("No");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}