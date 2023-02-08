

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 제곱 ㄴㄴ 수
public class Main {
    public static void main(String[] args) throws IOException {

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

