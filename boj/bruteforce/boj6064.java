package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 6064 카잉달력
 */
public class boj6064 {
    static int m, n, x, y;

    static int t;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;

            cnt = 1;

            boolean flag = false;
            for (int j = x; j < (n * m); j += m) {
                if (j % n == y) {
                    System.out.println(j + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1);

            }

//            func(1, 1, cnt);
        }
//        System.out.println(sb.toString());

    }

//    public static void func(int input_x, int input_y, int cnt) {
//
//
//        // 종말의해에 도달
//        if (input_x >= m && input_y >=n) {
//            sb.append(-1+"\n");
//            return;
//        }
//        // 종말의 해에 도달하지 않았지만, x,y의 표현 자체가 도달할 수 없는 수라면?
//        // 이것을 어떻게 검증해줄 수 있지?
//        // 혹은 m,n의 최대 크기가 40000이므로 재귀적으로 호출회수가 많아서 틀린걸까?
//
//
//
//        if (input_x == x && input_y == y) {
//            sb.append(cnt+"\n");
//            return;
//        }
//
//        int newY = 0;
//        int newX = 0;
//
//        if (input_x < m) {
//            input_x++;
//            newX = input_x;
//        } else {
//            newX = 1;
//        }
//
//        if (input_y < n) {
//            input_y++;
//            newY = input_y;
//        } else {
//            newY = 1;
//        }
//
//        func(newX, newY, cnt + 1);
//
//
//    }
}
