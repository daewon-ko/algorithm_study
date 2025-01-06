
package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//트럭
public class boj13335 {
    static int n, w, l;
    static int consumedTime = 0;
    static List<Truck> truckList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckList.add(new Truck(0, 0, Integer.parseInt(st.nextToken()), 0));
        }

        solve();

    }

    public static void solve() {
        int sum = 0;
        List<Truck> onBridgeTruck = new ArrayList<>();

        for (int i = 0; i < truckList.size(); i++) {
            sum += truckList.get(i).getWeight();

            if (sum <= l) {
                // sum<=l이면 다리 위에 올라갈 수 있다.
                // 다리 위에 올라갈 수 있는 트럭을 list에 넣는다.
                onBridgeTruck.add(truckList.get(i));
            }

            if (sum > l) {
                // sum>l이면 해당 i번째 트럭을 제외한 이전 트럭들에 대해서 연산해준다.
                calculateConsumedTime(onBridgeTruck);

                // 계산 직후 sum 초기화
                sum = 0;

                // 무게가 초과되어 다리위에 올라가지 못한 i를 다음번에
                // 올리기 위해 해당 트럭의 무게를 sum에 합쳐주고
                sum += truckList.get(i).getWeight();
                // 다리 위 트럭도 다시 초기화 한 이후,
                onBridgeTruck = new ArrayList();

                // 다리 위에 올라갈 트럭에 해당 트럭을 가장 첫번쨰로 넣어준다.
                onBridgeTruck.add(truckList.get(i));

            }

        }

    }

    public static void calculateConsumedTime(List<Truck> onBridgeTruckList) {

        // 다리 위에 올라간 가장 마지막 트럭의 위치가 w라는 다리의 길이이자 위치점보다 작다면
        // 로직은 계속해서 수행된다.
        while (onBridgeTruckList.get(onBridgeTruckList.size() - 1).getEndPosition() < w) {

            for (int i = 0; i < onBridgeTruckList.size(); i++) {
                Truck truck = onBridgeTruckList.get(i);

                while (truck.getEndPosition() >= w) {
                    truck.endPosition++;
                    consumedTime++;
                }
            }

        }

    }

    static class Truck {
        int startPosition;
        int endPosition;
        int weight;
        int time;

        public Truck(final int startPosition, final int endPosition, final int weight, final int time) {
            this.startPosition = startPosition;
            this.endPosition = endPosition;
            this.weight = weight;
            this.time = time;
        }

        public int getStartPosition() {
            return startPosition;
        }

        public int getEndPosition() {
            return endPosition;
        }

        public int getWeight() {
            return weight;
        }

        public int getTime() {
            return time;
        }
    }
}


class boj13335Ref{
    static int w;
    static int n;
    static int l;

    static int [] trucks;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        trucks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }


        solve(trucks);




    }

    public static int solve(int[] trucks) {
        // queue에 들어가는 것은 기본적으로 0 이지만,
        // 특정 트럭이 올라가면, 트럭의 무게로 표현된다.
        // 트럭에 관한 정보는 트럭의 무게만 존재하기에.
        Queue<Integer> queue = new LinkedList();
        int index = 0;
        int time = 0;
        int weight = 0;

        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        // 다리를 아직 지나지 않은 트럭이 있거나 다리 위에 트럭이 있으면 반복문을 계속 수행한다.
        while (index < trucks.length ||weight > 0) {
            // 1시간 지나서 가장 먼저 queue에 들어간 것을 꺼낸다.
            // 그것은 0이될수도 혹은 다리 위에 트럭이 될 수도 있다.
            time++;
            weight-=queue.poll();

            if (index < trucks.length && weight + trucks[index] <= l) {
                weight += trucks[index];
                queue.add(trucks[index]);
                index++;

            }else{
                queue.add(0);
            }

        }

        return time;
    }
}

