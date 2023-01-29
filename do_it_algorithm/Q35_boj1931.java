package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q35_boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2차원 배열 time 선언
        int[][] time = new int[n][2];

        // 2차원 배열 time 값 할당
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // end 값이 같다면 start의 값으로 오름차순 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                // end 값이 같지 않다면, end값으로 오름차순 정렬
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_endTime = 0;

        for (int i = 0; i < n; i++) {
            if (prev_endTime <= time[i][0]) {
                prev_endTime = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
