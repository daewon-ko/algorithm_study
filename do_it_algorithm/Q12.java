package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 17298번
public class Q12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            // 스택이 비어있지 않고, 현재 원소가 스택의 맨 위 원소보다 큰 경우 stack의 원소를 Pop하고
            // 해당 인덱스의 값을 원소로 가져온다.
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }
            // stack에 넣는 값은 배열의 인덱스
            stack.push(i);
        }
        // 위의 while문을 다 돌고 나서 stack에 남아있는 값이 있다면 해당 인덱스의 seq 값을 -1로 변환
        // 왜냐하면 stack에 값이 남아 있다는 의미는 해당 인덱스의 seq 값의 오른쪽에는 자신보다 큰 값이 없다는 뜻이므로
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;

        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }
}
