package programmers.programmers.src.main.java.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static String[][] graph;
    static int startY = 0;
    static int startX = 0;
    static int endY = 0;
    static int endX = 0;

    static boolean[][] visited;
    static int n;

    static boolean isLeverPassed;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};


    static int answer = Integer.MAX_VALUE;

    public int solution(String[] maps) {
        n = maps.length;


        // graph 초기화 및 할당
        graph = new String[n][5];
        visited = new boolean[n][5];

        for (int i = 0; i < n; i++) {
            String map = maps[i];
            for (int j = 0; j < 5; j++) {

                graph[i][j] = String.valueOf(map.charAt(j));
                if (graph[i][j].equals("S")) {
                    // 시작점 기록
                    startY = i;
                    startX = j;
                } else if (graph[i][j].equals("E")) {
                    endY = i;
                    endX = j;
                }
            }
        }


        dfs(startY, startX, 0);

        if (!isLeverPassed && answer == 0) {
            answer = -1;
        }


        return answer;
    }

    public static void dfs(int y, int x, int cnt) {

        // 종료조건
        if (isLeverPassed && y == endY && x == endX) {
            answer = Math.min(answer, cnt);
            return;
        }

        // -1을 return을 어디서 어떻게 어떤 방식으로 해줘야할까?



        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];


            if (inRange(newY, newX) && !visited[newY][newX]) {

                if (graph[newY][newX].equals("L")) {
                    isLeverPassed = true;
                }

                visited[newY][newX] = true;
                dfs(newY, newX, cnt + 1);
                visited[newY][newX] = false;
            }

        }

    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < 5;

    }
}


class 미로탈출Ref{
    static int n;
    static String [][] graph;
    static boolean[][] visited;

    static int startX, startY, leverY, leverX, endY, endX;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int solution(String[] maps) {

        int answer = 0;

        n = maps.length;
        graph = new String[n][5];
        visited = new boolean[n][5];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                graph[i][j] = String.valueOf(maps[i].charAt(j));

                if(graph[i][j].equals("S")) {
                    startY = i;
                    startX = j;
                } else if (graph[i][j].equals("L")) {
                    leverY = i;
                    leverX = j;
                }
                else if(graph[i][j].equals("E")) {
                    endY = i;
                    endX = j;

                }
            }
        }


        int leverDistance = bfs(startY, startX, leverY, leverX);
        if (leverDistance == -1) {
            return -1;
        }
        int leverToEndDistance = bfs(leverY, leverX, startY, startX);
        if (leverToEndDistance == -1) {
            return -1;
        }

        answer = leverDistance + leverToEndDistance;

        return answer;


    }

    public static int bfs(int startY, int startX, int targetY, int targetX) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollY = poll.y;
            int pollX = poll.x;
            int pollDistance = poll.distance;

            // 종료조건
            if (pollY == targetY && pollX == targetX) {
                return pollDistance;
            }


            for (int i = 0; i < 4; i++) {
                int newY = pollY + dy[i];
                int newX = pollX + dx[i];
                if (inRange(newY, newX) && !visited[newY][newX] && !graph[newY][newX].equals("X")) {
                    visited[newY][newX] = true;
                    queue.offer(new Node(newY, newX, pollDistance+1));
                }


            }

        }


        // 목표지점 도달 불가능 시
        return -1;




    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < 5;

    }

    static class Node{
        int y;
        int x;
        int distance;

        Node(int y, int x, int distance){
            this.y= y;
            this.x = x;
            this.distance = distance;
        }
    }


}
