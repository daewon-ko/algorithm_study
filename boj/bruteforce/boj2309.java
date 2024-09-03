package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
/**
 * 일곱 난쟁이
 */
public class boj2309 {
    static int [] arr;
    static boolean [] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        visited = new boolean[9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        func(0, 0);

    }

    public static void func(int start, int depth) {
        if (depth == 7) {
            int answer = 0;
            for (int i = 0; i < list.size(); i++) {
                answer += list.get(i);
            }
            if (answer == 100) {
                sortAndPrint();
                System.exit(0);
            }

            return;
        }

        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                func(start + 1, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void sortAndPrint() {
        // 오름차순 정렬
        Collections.sort(list);

        // 출력
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}

class boj2309_ref{
    static int[] n = new int[9];
    static int sum = 0;
    static int fake1, fake2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            n[i] = Integer.parseInt(br.readLine());
            sum += n[i];

        }


        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (sum - n[i] - n[j] == 100) { // 순서가 상관 없기에 즉. 아무거나 나오면 되기에 가능한 조건
                    fake1 = n[i];
                    fake2 = n[j];
                }
            }
        }

        Arrays.sort(n);

        for (int i = 0; i < n.length; i++) {
            if (n[i] != fake1 && n[i] != fake2) {
                System.out.println(n[i]);
            }

        }

    }
}
