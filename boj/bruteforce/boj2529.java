package boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2529 {



        static int K;
        static int[] numbers;
        static char[] arr;
        static boolean[] visited;
        static ArrayList<String> answer = new ArrayList<>();

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            K = Integer.parseInt(br.readLine());
            arr = new char[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                arr[i] = st.nextToken().charAt(0);
            }
            numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = i;
            }

            for (int i = 0; i < 10; i++) {
                visited = new boolean[10];
                visited[i] = true;
                dfs(i, 0, new StringBuilder().append(i));
                visited[i] = false;
            }
            System.out.println(answer.get(answer.size() - 1));
            System.out.println(answer.get(0));
        }

        private static void dfs(int start, int cnt, StringBuilder word) {
            if (word.length() == K+1) { //부등호의 모든 조건을 달성하면 종료
                answer.add(word.toString());
                return;
            }
            for (int i = 0; i < 10; i++) {
                if (!visited[i]) {
                    char tmp = arr[cnt];
                    if (tmp == '>') {
                        if (start > i) {
                            visited[i] = true;
                            dfs(i, cnt + 1, word.append(i));
                            word.deleteCharAt(word.length() - 1);
                            visited[i] = false;
                        }
                    } else {
                        if (start < i) {
                            visited[i] = true;
                            dfs(i, cnt + 1, word.append(i));
                            word.deleteCharAt(word.length() - 1);
                            visited[i] = false;
                        }
                    }
                }
            }
        }
    }





class boj2529Re {


    static int K;
    static int[] numbers;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()) + 1;
        arr = new char[K - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K - 1; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, 0, i + "");
            visited[i] = false;
        }
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    private static void dfs(int start, int cnt, String word) {
        if (word.length() == K) { //부등호의 모든 조건을 달성하면 종료
            answer.add(word);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                char tmp = arr[cnt];
                if (tmp == '>') {
                    if (start > i) {
                        visited[i] = true;
                        dfs(i, cnt + 1, word + i);
                        visited[i] = false;
                    }
                } else {
                    if (start < i) {
                        visited[i] = true;
                        dfs(i, cnt + 1, word + i);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}





