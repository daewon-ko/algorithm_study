package boj.스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//백준 소수구하기
public class boj1929 {
    static int m,n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        // 2부터 n까지의 수를 배열에 넣어준다.
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }



        // 에라토스테네스의 체의 기본 개념
        // 2부터 시작해서 특정 수의 배수는 0으로 처리한다.

        // 2부터 n까지의 수 중 소수를 찾아서 0으로 바꿔준다.
        /**
         * n^2만큼 검사하면 시간초과가 발생한다.
         *
         * 어떤 수의 소수 여부를 판단하려면 특정 숫자의 제곱근까지만 약수여부를 검증하면 된다.
         * -> n = a*b라면 a와 b중 하나는 반드시 n의 제곱근 이하이기 때문이다.
         *
         * 해당 개념을 이용하면 시간복잡도가 n^1/2으로 줄어든다.
         * 따라서 제곱근만큼 검사하면 되는데, 이유는 제곱근 이상의 수는 이미 검사가 되어있기 때문이다.
         */
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 0일 경우,  continue
            // 아래의 for문에서 i의 배수를 0으로 바꿔주기 때문에 0인 경우는 소수가 아니기 때문에 continue
            if (arr[i] == 0) {
                continue;
            }

            // 제곱근의 배수에 해당하는 수는 소수가 될 수 없으므로 0으로 바꿔준다.
            for (int j = i + i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }


        // 소수 출력
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }


    }


}
