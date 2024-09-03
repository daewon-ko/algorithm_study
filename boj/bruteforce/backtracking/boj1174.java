package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 줄어드는 수
 * 3*10^2 + 2* 10^1 + 1*10^0 : 2 -> 1 -> 0 따라서 줄어드는수
 * 0 : 왜 0은 첫번째로 줄어드는 수일까?
 */
public class boj1174 {
    static int n;
    static int cnt = 0;
    static int answer = 0;
    static List<Integer> list = new ArrayList<>();

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//
//        func(n, 0);
//        System.out.println(answer);
//    }
//
//    public static void func(int n, int number) {
//
//        // 그러한 수가 없을때는 -1 출력을 어떻게 설정해주지?
//
////        if (cnt)
//
//        if (cnt == n) {
//            if (n == 1) {
//                answer = number - 1;
//            }else{
//                answer = number;
//            }
//
//            return;
//        }
//
//        int degree = number / 10;// 자리수 계산
//
//        if (degree == 0) {
//            cnt++;
//            func(n, number + 1);
//        } else {
//            if (degree >= 1) {  // 최소 2자리수가 있다면?
//                for (int i = 0; i < degree; i++) {
//                    int divided = number % 10;
//                    list.add(divided);
//                }
//            }
//
//
//            Collections.reverse(list);
//            boolean flag = true;
//
//            for (int i = 0; i < list.size() - 1; i++) {
//                Integer i1 = list.get(i);
//                Integer i2 = list.get(i + 1);
//                if (i1 > i2) {
//                    flag = false;
//                }
//            }
//            if (flag) {
//                cnt++;
//            }
//            func(n, number + 1);
//        }
//
//
//
//
//
//    }
}

class boj1174_re{
    static int n;
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        recursive(0, 0);
        Collections.sort(list);
        try {
            System.out.println(list.get(n - 1));
        } catch (Exception e) {
            System.out.println(-1);

        }
    }

    public static void recursive(long num, int depth) {
        if (!list.contains(num)) {
            list.add(num);
        }

        if (depth >= 10) {
            return;
        }

        recursive(num * 10 + arr[depth], depth + 1);
        recursive(num, depth + 1);
    }
}
