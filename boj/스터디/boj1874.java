package boj.스터디;

// 백준 스택수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1874 {
    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        stack();


    }

    public static void stack() {
        for (int i = 1; i < list.size(); i++) {
            int before = list.get(i - 1);
            // 첫 번째 숫자는 무조건 push

            for (int j = 0; j < before; j++) {
                System.out.println("+");
            }


            before = list.get(i - 1);
            int next = list.get(i);

            if (before > next) {
                // pop해야함
                // before-next만큼 pop
                for (int j = 0; j <= before - next; j++) {
                    System.out.println("-");
                }
            } else if (before < next) {
                // push해야함
                // next-before만큼 push
                for (int j = 0; j < next - before; j++) {
                    System.out.println("+");
                }
            }

        }

    }
}

}
