package boj.bfs_dfs.바킹독;

// 백준 텀 프로젝트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 재귀로도 풀 수 있고, 다른방식으로 풀 수도 있다.
 * 일단은 혼자서 재귀까지 접근하는 것은 시도해봤으나 직접 구현하는데에는 실패했다.
 */
public class boj9466 {
    static int t, n;
    static int []arr;
    static int [] state;
    static final int MAX = 100000;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        int cnt = 0;


        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[MAX];
            state = new int[MAX];

//            // state 배열 기본값 0으로 초기화
//            for (int j = 1; j <= n; j++) {
//                state[j] = 0;
//            }
            // 위의 반복문과 똑같은 의미
            Arrays.fill(state, 1, n + 1, 0);

            for (int j = 1; j <= n; j++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (state[i] == 0) {
                    run(i);
                }
            }
            for (int j = 1; j <= n; j++) {
                if (state[j] == -1) {
                    cnt++;
                }
            }
            System.out.println(n - cnt);
        }
    }

    /**
     * 어떤 노드(학생)을 고르든 결국엔 사이클이 완성되므로 while문으로 처리가능하다.
     * 즉, while문을 반복해서 순회하며 if또는 else-if 조건문이 돌기 전까지 계속해서 state 배열과 arr[cur]을 이용하여
     * 다음 노드로 이동하게끔 해준다.
     * @param x
     */

    public static void run(int x) {
        int cur = x;

        while (true) {
            state[cur] = x;
            cur = arr[cur];

            if (state[cur] == x) {  // 사이클을 한바퀴 돌았을때,즉 팀을 형성하는 것들을 의미한다.
                while (state[cur] != -1) {  // 팀
                    state[cur] = -1;
                    cur = arr[cur];
                }
                return;
            } else if (state[cur] != 0) {  // 이미 방문한노드?
                return;
            }
        }
    }
}
