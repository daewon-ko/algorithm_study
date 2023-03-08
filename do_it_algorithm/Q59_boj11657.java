//package do_it_algorithm;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//// 백준 타임머신 문제(벨만-포드)
//public class Q59_boj11657 {
//
//
//        static int N, M;
//        static ArrayList<ArrayList<City>> list;
//
//    // 자료형을 int로 할 경우 오버플로우 발생함.
//    // 왜 오버플로우가 발생할까? 이유는 무엇이지?
//        static long[] dist;
//
//        public static void main(String[] args) throws NumberFormatException, IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            N = Integer.parseInt(st.nextToken()); // 도시의 개수
//            M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
//
//            list = new ArrayList<>(); // 인접 리스트
//            dist = new long[N + 1]; // 최단거리 배열
//
//            for (int i = 0; i <= N; i++) {
//                list.add(new ArrayList<>());
//                dist[i] = Integer.MAX_VALUE;
//            }
//
//            // 단방향 인접리스트 구현
//            for (int i = 0; i < M; i++) {
//                st = new StringTokenizer(br.readLine());
//                int A = Integer.parseInt(st.nextToken());
//                int B = Integer.parseInt(st.nextToken());
//                int C = Integer.parseInt(st.nextToken());
//
//                list.get(A).add(new City(B, C));
//            }
//
//            StringBuilder sb = new StringBuilder();
//            if (bellmanFord()) {
//                sb.append("-1\n");
//            } else {
//                // 한 번 더 체크.
//                for (int i = 2; i <= N; i++) {
//                    if (dist[i] == Integer.MAX_VALUE) {
//                        sb.append("-1\n");
//                    } else {
//                        sb.append(dist[i] + "\n");
//                    }
//                }
//            }
//
//            bw.write(sb.toString());
//            bw.flush();
//            bw.close();
//            br.close();
//        }
//
//        public static boolean bellmanFord() {
//            dist[1] = 0; // 시작점은 0으로 초기화.
//            boolean update = false;
//
//            // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
//            for (int i = 1; i < N; i++) {
//                update = false;
//
//                // 최단거리 초기화.
//                for (int j = 1; j <= N; j++) {
//                    for (City city : list.get(j)) {
//                        if (dist[j] == Integer.MAX_VALUE) {
//                            break;
//                        }
//
//                        if (dist[city.end] > dist[j] + city.weight) {
//                            dist[city.end] = dist[j] + city.weight;
//                            update = true;
//                        }
//                    }
//                }
//
//                // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
//                if (!update) {
//                    break;
//                }
//            }
//
//            // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
//            // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
//            if (update) {
//                for (int i = 1; i <= N; i++) {
//                    for (City city : list.get(i)) {
//                        if (dist[i] == Integer.MAX_VALUE) {
//                            break;
//                        }
//
//                        if (dist[city.end] > dist[i] + city.weight)
//                            return true;
//                        }
//                    }
//                }
//            }
//
//            return false;
//        }
//
//    }
//
//
//class City {
//    int end;
//    int weight;
//
//    City(int end, int weight) {
//        this.end = end;
//        this.weight = weight;
//    }
//}
//
