package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj15663 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        set = new LinkedHashSet<>();

        func(0, new StringBuilder().append(""));

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String number = iterator.next();
            for (int i = 0; i < number.length(); i++) {
                System.out.print(number.charAt(i) + " ");
            }
            System.out.println();
        }


    }

    public static void func(int depth, StringBuilder numberBase) {
        if (depth == m) {


            set.add(numberBase.toString());

            return;

        }

        int prevNum = -1; // 이전 숫자를 저장할 변수

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[i] != prevNum) {

                visited[i] = true;
                String number = String.valueOf(arr[i]);
                numberBase.append(number);
                func(depth + 1, numberBase);
                numberBase.deleteCharAt(numberBase.length() - 1);
                visited[i] = false;
                prevNum = arr[i]; // 이전 숫자를 저장할 변수
            }
        }

    }
}

