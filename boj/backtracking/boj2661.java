package boj.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 좋은수열
 */
public class boj2661 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        func("");

    }

    public static void func(String str) {
        if (str.length() == n ) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <=3; i++) {
            if (isGoodSequence(str + i)) {
                func(str + i);
            }
        }

    }

    public static boolean isGoodSequence(String str) {
        int len = str.length() / 2;
        for (int i = 1; i <= len; i++) {
            if (str.substring(str.length() - i)
                    .equals(str.substring(str.length() - 2 * i, str.length()-i))) {
                return false;
            }
        }
        return true;
    }
}
