package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
