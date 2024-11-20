package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15662 {
    static int t;
    static int k;
    static final int clockWise = 1;
    static final int reverseClockWise = -1;

    static List<int[]> saw = new ArrayList<>();

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            // 톱니개수는 8개로 고정되므로 크기가 8인 배열을 생성
            int[] arr = new int[8];

            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                // 배열의 요소에 각각의 값들을 넣는다.
                arr[j] = Integer.valueOf(line.charAt(j));
            }
            // list에 배열을 넣는다.
            saw.add(arr);
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int targetSawNumber = Integer.parseInt(st.nextToken()) -1;
            int direction = Integer.parseInt(st.nextToken());

            func(targetSawNumber, direction);

        }


        countS();
        System.out.println(cnt);

    }

    public static void func(int targetSawNumber, int direction) {

        int[] directions = new int[t];

        directions[targetSawNumber] = direction;

        for (int i = targetSawNumber; i < t-1; i++) {
            if (saw.get(i)[2] != saw.get(i + 1)[6]) {
                directions[i + 1] = -directions[i];
            }
            else
                break;
        }

        for (int i = targetSawNumber; i > 0; i--) {
            if (saw.get(i)[6] != saw.get(i - 1)[2]) {
                directions[i-1] = - directions[i]; 
            } else 
                break;
        }


        for (int i = 0; i < t; i++) {

            // directions[i] 값이 1 또는 -1이라면 해당 톱니바퀴에 대해서 rotate함수를 호출한다.
            if (directions[i] != 0) {
                rotate(saw.get(i), directions[i]);
            }
        }
        
    }

    public static void rotate(int[] arr, int direction) {
        if (direction == clockWise) {
            int temp = arr[7];
            for (int i = 7; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        } else if (direction == reverseClockWise) {
            int temp = arr[0];
            for (int i = 0; i < 7; i++) {
                arr[i] = arr[i + 1];
            }
            arr[7] = temp;
        }
    }

//    public static void rotate(int[] saw, int direction) {
//
//        // direction이 1일때 -> 배열을 시계 방향으로 회전한다.
//        if (direction == clockWise) {
//            int temp = saw[7];
//
//            for (int i = 0; i < 7; i++) {
//                saw[i + 1] = saw[i];
//            }
//
//            saw[0] = temp;
//
//        } else if (direction == reverseClockWise) {
//            int temp = saw[0];
//
//            for (int i = 7; i > 0; i--) {
//                saw[i-1] = saw[i];
//            }
//            saw[7] = temp;
//        }
//
//        // direction이 -1일때
//
//    }

    public static void countS() {
        for (int i = 0; i < t; i++) {
            if (saw.get(i)[0] == 1) {
                cnt++;

            }
        }
    }
}
