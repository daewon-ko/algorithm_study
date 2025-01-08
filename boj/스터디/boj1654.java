package boj.스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 랜선 자르기
public class boj1654 {
    static int k, n;
    static List<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(br.readLine());
            if (min >= line) {
                min = line;
            }
            list.add(line);

        }

        solve();
        System.out.println(min);

    }
    public static void solve() {
        // 초기 cnt 0으로 초기화

        while (true) {
            // 반복시마다 초기화
            int cnt = 0;

            for (int i = 0; i < list.size(); i++) {
                int givenLineLength = list.get(i);
                // 주어진 랜선 중 가장 작은 길이의 랜선 길이의 수로
                // 주어진 랜선을 나눈다.

                cnt += (givenLineLength / min);


            }

            if (cnt >= n) {
                break;
            }

            min--;

        }
    }
}
