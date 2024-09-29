package boj.bruteforce;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크와 스타트
 */
public class boj15661 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < n; i++) {
            t = i;
            func(0, 0);
        }

        System.out.println(MIN);


    }

    public static void func(int start, int depth) {
        if (depth == t) {
            int start_team = 0;
            int link_team = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start_team += map[i][j];
                        start_team += map[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link_team += map[i][j];
                        link_team += map[j][i];
                    }
                }

            }

            int val = Math.abs(start_team - link_team);

            if (val == 0) {
                System.out.println(0);
                System.exit(0);
            }

            MIN = Math.min(MIN, val);


            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
