package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 제곱 ㄴㄴ 수
public class Q40_boj1016 {
    public static void main(String[] args) throws IOException {
        /*
        문제 이해 자체가 쉽지 않음.

        1. min과 max(둘이 같을 수도 있음) 사이에서 정수의 제곱수로 나누어 떨어지지 않는다면( 즉, 정수의 제곱수가 무엇이 되었든 하나라도 안 나누어진다면)
        해당 수는 제곱 ㄴㄴ수라고 함.
        2. min과 max의 크기가 심상치 않음. 값이 굉장히 큰데 이것이 시간복잡도와 어떻게 얼마나 연관되어있을까?
        3. Min의 크기 자체가 10의 13승까지.
        4. 제곱수는 어떻게 표현해줄까?
        -> Math.pow 함수

        - 입력을 통해서 min, max 값을 입력받고
        - 해당 크기만큼의 배열을 선언하고 값을 할당
        - 그 배열에서 if 조건 내지는 static 함수를 선언하여서 cnt++를 해준다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // min과 max값이 같을 수도 있음.
        int num = (int) ((max - min) + 1);
        // num 갯수만큼 boolean 배열 생성
        boolean[] check = new boolean[num];
        int sqrt = (int) (Math.sqrt(max));
        for (long i = 2; i <= sqrt; i++) {
            long squared = i * i;
            // 사실 밑에 식을 세우는 부분이 좀 이해가 안 감.
            long start = min % squared == 0 ? min / squared : (min / squared) + 1;
            for (long j = start; j * squared <=max; j++) {
                check[(int) ((j * squared) - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < num ; i++) {
            if (!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}

