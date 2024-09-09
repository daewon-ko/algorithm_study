package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

/**
 * 백준 리모컨
 */
public class boj1107 {
    static int cnt;
    static int n, m;
    static List<Integer> numbers;

    static int[] arr;

    static int goal_length;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        numbers = new ArrayList<>();
        arr = new int[10];
        visited = new boolean[10];

        // 0~9 초기화(리모컨 본래 숫자들)
        for (int i = 0; i <= 9; i++) {
//            numbers.add(i);
            arr[i] = i;
        }

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        String goal_number = String.valueOf(n);
        goal_length = goal_number.length();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 리모컨 숫자중 고장난 버튼 삭제(해당 버튼은 못 누르게끔 한다.)
        for (int i = 0; i < m; i++) {
            int exceptNumber = Integer.parseInt(st.nextToken());
            visited[exceptNumber] = true;
//            numbers.remove(exceptNumber);
        }

        cnt = 0;

        resolveButton(0);

        System.out.println(answer);


    }

    public static void resolveButton(int depth) {
        if (n == 100) {
            answer = 0;
            return;
        }


        if (depth == goal_length) {
            // goal_length만큼 숫자를 꼽았다.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.size(); i++) {
                sb.append(numbers.get(i));
            }
            int number = Integer.parseInt(sb.toString());
            answer = Math.min(answer, (Math.abs(n - number) + goal_length));
            return;

        }

        // 반복문 조건이 좀 이상한 듯. 생각이 잘 안 난다.
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
//                visited[i] = true;
                numbers.add(arr[i]);
//                sb.append(arr[i]);
                resolveButton(depth + 1);
                // 삭제
                numbers.remove(numbers.size() - 1);
//                visited[i] = false;
            }

        }
    }
}

