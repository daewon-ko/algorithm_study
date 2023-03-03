package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//케빈 베이컨 6단계 법칙
public class Q63_boj1389 {
    static int[][] arr;
    static boolean visit[];
    static int n, m;
    static int result;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
        1. BFS를 통한 구현
        2. 플로이드 마샬 알고리즘을 통한 구현
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            BFS(i);
        }
        System.out.println(result);

    }

    static void BFS(int start) {
        Queue<Bacon> queue = new LinkedList<>();
        visit[start] = true;
        int count = 0;
        // start Point에서 value 값은 0일 수밖에 없다. 이동한 것이 없으므로.
        queue.offer(new Bacon(start, 0));
        while (!queue.isEmpty()) {
            Bacon now = queue.poll();
            count += now.value;
            for (int i = 1; i <= n; i++) {
                int num = arr[now.end][i];
                if (!visit[i] && num == 1) {
                    visit[i] = true;
                    queue.offer(new Bacon(i,now.value+1));
                }
            }
        }
        if(min>count){
            min = count;
            result = start;
        }
    }

    static class Bacon {
        int end;
        int value;

        Bacon(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
}
