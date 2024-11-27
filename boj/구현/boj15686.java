package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달
public class boj15686 {
    static int n,m;
    static int [][] graph;
    static List<House> houseList = new ArrayList<>();
    static List<ChickenShop> chickenShopList = new ArrayList<>();
    static boolean visited[];
    static int chickenShopSize;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 1) {
                    houseList.add(new House(i, j));
                } else if (graph[i][j] == 2) {
                    chickenShopList.add(new ChickenShop(i, j));
                }
            }
        }

//        int minChickenShopCnt = chickenShopList.size() - m;


        // 치킨가게 수만큼 visited의 크기를 설정한다.
        chickenShopSize = chickenShopList.size();
        visited = new boolean[chickenShopSize];

        //  m-> 폐업시키지 않을 치킨집의 개수
        // 1보다 크거나 같고 13보다 작거나 같다.
        // chike
        int removeMaxCnt = chickenShopSize - 1;
        int removeMinCnt = chickenShopSize - 13;

        // 폐업시킬 치킨집의 개수를 최소 개수부터 최대개까지 반복한다.
        for (int i = removeMinCnt; i <= removeMaxCnt; i++) {

            backtracking(i, 0);
        }

        System.out.println(MIN);

    }

    private static void backtracking(int removeCnt, int startCnt) {


        //
        if (startCnt == removeCnt) {
            int total =0;
            for (int i = 0; i < chickenShopSize; i++) {
                // 제거되지 않은 치킨샵을 기준으로
                if (!visited[i]) {
                    //
                    total += calculateChickenDistance(i);
                }
            }

            MIN = Math.min(MIN, total);
            return;
        }




        for (int j = 0; j < chickenShopSize; j++) {
            if (!visited[j]) {
                // j번째 치킨가게를 폐업한다.
                visited[j] = true;
                backtracking(removeCnt, startCnt + 1);
                visited[j] = false;

            }
        }
    }

    public static int calculateChickenDistance(int chickenShopNumber) {

        // 치킨샵을 기준으로 모든 하우스와의 최솟값을 계산한다.

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < houseList.size(); i++) {
            House house = houseList.get(i);
            int houseX = house.x;
            int houseY = house.y;

            ChickenShop chickenShop = chickenShopList.get(chickenShopNumber);
            int chickenY = chickenShop.y;
            int chickenX = chickenShop.x;

            int sum = Math.abs(houseY - chickenY) + Math.abs(houseX - chickenX);

            min = Math.min(sum, min);

        }
        return min;
    }
    static class House{
        int y;
        int x;

        public House(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class ChickenShop{
        int y;
        int x;

        public ChickenShop(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
}

class boj15686Ref{


    // 치킨 배달
    public class boj15686 {
        static int n, m;
        static int[][] graph;
        static List<House> houseList = new ArrayList<>();
        static List<ChickenShop> chickenShopList = new ArrayList<>();
        static boolean[] visited;
        static int chickenShopSize;
        static int MIN = Integer.MAX_VALUE;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());

                    if (graph[i][j] == 1) {
                        houseList.add(new House(i, j));
                    } else if (graph[i][j] == 2) {
                        chickenShopList.add(new ChickenShop(i, j));
                    }
                }
            }

            chickenShopSize = chickenShopList.size();
            visited = new boolean[chickenShopSize];

            backtracking(0, 0); // 백트래킹 시작
            System.out.println(MIN);
        }

        private static void backtracking(int depth, int start) {
            // M개이하의 치킨집을 선택한 경우

            if (depth >m) {
                int totalDistance = calculateChickenDistance();
                MIN = Math.min(MIN, totalDistance);
            }

            if (depth == m) {
                return;
            }

            for (int i = start; i < chickenShopSize; i++) {
                if (!visited[i]) {
                    visited[i] = true;  // 치킨집 선택
                    backtracking(depth + 1, i + 1);
                    visited[i] = false; // 치킨집 선택 해제
                }
            }
        }

        public static int calculateChickenDistance() {
            int totalDistance = 0;

            for (House house : houseList) {
                int minDistance = Integer.MAX_VALUE;

                // 선택된 치킨집들 중 가장 가까운 거리 계산
                for (int i = 0; i < chickenShopSize; i++) {
                    if (!visited[i]) continue; // 선택되지 않은 치킨집은 스킵
                    ChickenShop chickenShop = chickenShopList.get(i);
                    int distance = Math.abs(house.x - chickenShop.x) + Math.abs(house.y - chickenShop.y);
                    minDistance = Math.min(minDistance, distance);
                }

                totalDistance += minDistance; // 도시의 치킨 거리 누적
            }

            return totalDistance;
        }

        static class House {
            int y;
            int x;

            public House(final int y, final int x) {
                this.y = y;
                this.x = x;
            }
        }

        static class ChickenShop {
            int y;
            int x;

            public ChickenShop(final int y, final int x) {
                this.y = y;
                this.x = x;
            }
        }
    }

}
