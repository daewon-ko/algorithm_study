package boj.bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 날짜계산
 */
public class boj1476 {
    static int e, s, m;
    static final int MAX_E = 15;
    static final int MAX_S = 28;
    static final int MAX_M = 19;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = 1;

        func();
        System.out.println(answer);

    }

    static void func() {
        int firstE = 1;
        int firstS = 1;
        int firstM = 1;
        boolean flag = true;
        while (flag) {

            if (firstE == e && firstS == s && firstM == m) {
                flag = false;
                return;
            }

            firstE = getValue(firstE, MAX_E);
            firstS = getValue(firstS, MAX_S);
            firstM = getValue(firstM, MAX_M);

            answer++;


        }

    }

    private static int getValue(int firstValue, final int max) {
        if (firstValue < max) {
            firstValue++;
        } else {
            firstValue = 1;
        }
        return firstValue;
    }
}
