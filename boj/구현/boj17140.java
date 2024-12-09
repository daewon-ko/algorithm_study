package boj.구현;
import java.io.*;
import java.util.*;

public class boj17140 {

        static int[][] A = new int[101][101];
        static int r, c, k;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 3; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int time = 0;

            while (time <= 100) {
                if (A[r][c] == k) {
                    System.out.println(time);
                    return;
                }

                if (rowSize() >= colSize()) {
                    ROperation();
                } else {
                    COperation();
                }
                time++;
            }

            System.out.println(-1);
        }

        static int rowSize() {
            for (int i = 100; i > 0; i--) { // 행을 뒤에서부터 탐색
                for (int j = 1; j <= 100; j++) { // 열은 앞에서부터 탐색
                    if (A[i][j] != 0) return i; // 값이 0이 아닌 가장 마지막 행 반환
                }
            }
            return 0; // 모든 값이 0이면 0 반환
        }

        static int colSize() {
            for (int j = 100; j > 0; j--) { // 열을 뒤에서부터 탐색
                for (int i = 1; i <= 100; i++) { // 행은 앞에서부터 탐색
                    if (A[i][j] != 0) return j; // 값이 0이 아닌 가장 마지막 열 반환
                }
            }
            return 0; // 모든 값이 0이면 0 반환
        }

        static void ROperation() {
            int maxCol = 0;

            for (int i = 1; i <= rowSize(); i++) {
                Map<Integer, Integer> map = new HashMap<>();

                for (int j = 1; j <= colSize(); j++) {
                    if (A[i][j] != 0) {
                        map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
                    }
                }

                List<int[]> list = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    list.add(new int[]{entry.getKey(), entry.getValue()});
                }

                list.sort((o1, o2) -> {
                    if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o1[1], o2[1]);
                });

                int col = 1;
                for (int[] arr : list) {
                    if (col > 100) break;
                    A[i][col++] = arr[0];
                    A[i][col++] = arr[1];
                }

                maxCol = Math.max(maxCol, col - 1);
                for (int j = col; j <= 100; j++) {
                    A[i][j] = 0;
                }
            }
        }

        static void COperation() {
            int maxRow = 0;

            for (int j = 1; j <= colSize(); j++) {
                Map<Integer, Integer> map = new HashMap<>();

                for (int i = 1; i <= rowSize(); i++) {
                    if (A[i][j] != 0) {
                        map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
                    }
                }

                List<int[]> list = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    list.add(new int[]{entry.getKey(), entry.getValue()});
                }

                list.sort((o1, o2) -> {
                    if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o1[1], o2[1]);
                });

                int row = 1;
                for (int[] arr : list) {
                    if (row > 100) break;
                    A[row++][j] = arr[0];
                    A[row++][j] = arr[1];
                }

                maxRow = Math.max(maxRow, row - 1);
                for (int i = row; i <= 100; i++) {
                    A[i][j] = 0;
                }
            }
        }
    }


