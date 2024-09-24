package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 백준 암호만들기
 */
public class boj1759 {
    static final int min_vowel = 1;
    static final int min_consonant = 2;
    static final int MAX = 15;

    static int l, c;

    // 아래같은 방법이 아니라 다른 방식으로 정의할 수도 있을 것 같은데? Char자료형의 숫자를 기입?
//    static String[] vowels = {"a", "e", "i", "o", "u"};
//    static String[] consonant = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
//
//    static boolean []vowel_visited;
//    static boolean [] consonant_visited;

    static boolean [] visited;

    static List<String> input = new ArrayList<String>();
    static List<String> output = new ArrayList<String>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

//        vowel_visited = new boolean[MAX];
//        consonant_visited = new boolean[MAX];

        visited = new boolean[MAX];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            input.add(st.nextToken());
        }

        // 입력값 오름차순 정렬
        Collections.sort(input);

        func(0, 0);




    }

    public static void func(int start, int depth) {

        if (depth == l) {
            int vowel_cnt = 0;
            int consonant_cnt = 0;
            for (String alpahbet : output) {
                if (alpahbet.equals("a") || alpahbet.equals("e") || alpahbet.equals("i") || alpahbet.equals("o") || alpahbet.equals("u")) {
                    vowel_cnt++;
                }else {
                    consonant_cnt++;
                }
            }

            if (vowel_cnt >= 1 && consonant_cnt >= 2) {


                for (String alpabet : output) {
                    System.out.printf(alpabet);
                }
                System.out.println();
            }


            return;
        }



        for (int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(input.get(i));
                func(i+1, depth + 1);
                output.remove(output.size() - 1);
                visited[i] = false;
            }
        }


    }
}
