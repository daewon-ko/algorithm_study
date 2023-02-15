package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 제곱 ㄴㄴ 수
public class Q40_boj1016 {

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
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        // num이라는 숫자는 boolean형으로 선언된 배열인 check의 인덱스로 할당되므로
        // 정수형으로 선언될 수 밖에 없다 (<- 배열 인덱스의 숫자는 항상 정수형으로 고정되어있다.)
        int num = (int) ((max - min) + 1);
        int sqrtNum = (int) Math.sqrt(max);
        boolean[] check = new boolean[num];
        // 궁금한 지점 -> i는 long형으로 지정되어있는데, sqrtNum은 int형으로 선언되어도 무방한가?
        // 무방하다면 어째서 무방할 수 있는가?
        for (long i = 2; i <=sqrtNum; i++) {
            long sqared = i * i;
            long start_index = min % sqared == 0 ? min / sqared : (min / sqared) + 1;
            for (long j = start_index; j * sqared <= max; j++) {
                check[(int) ((j * sqared) - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < num; i++) {
            if (!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}

