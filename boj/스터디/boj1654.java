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

class boj1654Retry {
    static int n, k;
    static int max;
    static int min = 1;
    static int mid;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(br.readLine());
            if (max <= line) {
                max = line;
            }
            list.add(line);

        }

        min = 1;
        mid = (max + min) / 2;

        solve();

        System.out.println(mid);
    }
    public static void solve() {


        while (true) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                int line = list.get(i);
                cnt += line / mid;
            }

            if (cnt > n) {
                min = mid + 1;
                mid = (max + min) / 2;

            } else if (cnt == n) {
                break;
            } else {
                max = mid - 1;
                mid = (max + min) / 2;
            }


        }
    }
}


class boj1654Ref{
    static int n, k;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int max = 0; // 가장 긴 랜선의 길이
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(br.readLine());
            max = Math.max(max, line); // 최대값 갱신
            list.add(line);
        }

        solve(1, max);


    }

    public static long solve(long min, long max) {
        long result = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int line : list) {
                cnt+=line / mid;
            }
            if (cnt >= n) {
                min = mid + 1;
                result = mid;
            }else{
                max = mid - 1;
            }
        }

        return result;
    }
}
