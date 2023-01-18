package do_it_algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// BOJ 2164번
public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Queue 생성
        Queue<Integer> queue = new LinkedList<>();
        // queuq에 1부터 n까지 값 넣기
        for(int i = 0 ;i<n; i++){
            queue.offer(i+1);
        }
        // queu의 크기가 1일때 까지 반복문 수행
        // 반복문의 내용 : queue에서 poll을 하고, 한 번 더 Poll해서 그 값을 offer한다
        // 즉, 맨 앞에 있던 수는 버리고, 그 뒤에 있던 수(2번째 수)를 다시 마지막에 넣는다.
        // 이 과정을 queue의 사이즈가 1이 될때까지 반복 수행
        while (queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
