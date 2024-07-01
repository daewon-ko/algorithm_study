package level2;

public class 쿼드압축후개수세기 {
        static int zeroCnt = 0;
        static int oneCnt = 0;

        public int[] solution(int[][] arr) {

            int size = arr.length;

            recursive(0, 0, arr, size);
            int[] answer = new int[]{zeroCnt, oneCnt};
            return answer;
        }

        public void recursive(int y, int x, int arr[][], int size) {


            if (validateGraph(y, x, arr,size)) {

                if (arr[y][x] == 0) {
                    zeroCnt++;
                    return;
                } else if (arr[y][x] == 1) {
                    oneCnt++;
                    return;
                }
            }
            int newSize = size/2;
            recursive(y, x, arr, newSize);
            recursive(y, x + newSize, arr, newSize);
            recursive(y + newSize, x, arr, newSize);
            recursive(y + newSize, x + newSize, arr, newSize);




        }

        public boolean validateGraph(int y, int x, int[][] arr, int size) {

            int standard = arr[y][x];

            for (int i = y; i <y+ size; i++) {
                for (int j = x; j < x+ size; j++) {
                    if (standard != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;


        }
    }


