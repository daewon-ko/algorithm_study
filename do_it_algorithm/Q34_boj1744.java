package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q34_boj1744 {
    public static void main(String[] args) throws IOException {
        /*
        일단 문제를 처음보고 드는 생각은 전 문제와 같이 PriorityQueue 구조를 이용해야하지 않을까 싶다는 것
        왜냐면 내부에 오름차순으로 내부정렬 기능이 있기 때문에!
        그런데 문제의 조건에도 나와있다시피 수열 숫자의 범위가 -1000~ 1000까지라서 음수와 음수일 경우를 고려해야하곡
        음수에서도 음수의 곱을 또 고려해줘야한다는 것?
        처음에 생각했을 때는 0보다 작을 때는 배제하려고 했으나, 음수와 음수의 곱이 더 값이 커질 수도 있다.
        자바 내에서 음수와 음수의 곱을 양수롤 구현하게끔은 되어있다.(println으로 찍어보면 알 수 있다.)
        음수는 음수끼리 곱하면 최대값을 구할 수 있지 않을까?
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // queue 내부에 값을 넣어줌
        for(int i = 0; i<n; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (queue.size()>1){
            int temp1 = queue.poll();
            int temp2 = queue.poll();
            int temp3 = temp1*temp2;
            if(temp1<0 && temp2<0) {
                queue.offer(temp3);
                sum += temp3;
            }else if(temp1!=0 && temp2!=0){
                queue.offer(temp3);
                sum+=temp3;
            }
            sum+=temp1+temp2;
        }
        System.out.println(sum);
    }
}
