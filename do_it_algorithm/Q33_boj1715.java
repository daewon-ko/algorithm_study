package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.PriorityQueue;

public class Q33_boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] A = new int[n];
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            queue.offer(Long.parseLong(br.readLine()));
        }
        long sum =0;
        while (queue.size()!=1){
            long temp1 = queue.poll();
            long temp2 = queue.poll();
            sum+=temp1+temp2;
            long temp3  = temp1+temp2;
            queue.offer(temp3);
        }
        System.out.println(sum);
//
//        for(int i = 0; i<n; i++){
//            A[i] = Integer.parseInt(br.readLine());
//        }
//        // 배열을 오름차순으로 정렬
//        Arrays.sort(A);

//      배열의 값을 꺼낼 때는 어떻게 하지? -> 통상 인덱스를 이용하여 반복문을 결합한다.
//      위와같이 배열을 이용할 때는 값을 두번씩 꺼내는데 제한적이다.
//      또한 문제 조건 상, 어떤 자료구조가 되었든 값을 꺼낸 후 더해서 다시 넣고 다시 더하는 구조이기 때문에
//      element의 삽입과 삭제가 빈번해지므로 배열은 적절한 방식이 아닐 수 있다.

    }
}
