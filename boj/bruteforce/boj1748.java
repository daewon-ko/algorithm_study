package boj.bruteforce;

import jdk.jfr.Frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 수 이어쓰기1
 */
public class boj1748 {
    static int n;
    static int answer;
    static int remain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String number = String.valueOf(n);
        int length = number.length();

        answer = 0;
        remain = 0;

        while (length >= 2) {
            int divide = 10;
            // length의 길이 -1만큼 반복한다.
            for (int i = 1; i < length-1; i++) {
                divide*=10;
            }

            remain = n % divide;

            answer += (n - divide + 1) * (length);


            n = divide -1;


            // 자리수 1을 낮춘다.
            length -= 1;


        }

        answer += n * length;

        System.out.println(answer);

    }
}
