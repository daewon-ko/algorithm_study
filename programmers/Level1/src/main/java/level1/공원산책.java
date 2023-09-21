package level1;

import java.util.Arrays;

public class 공원산책 {
    public static void main(String[] args) {
        String[] park = {"S00", "0XX", "000"};
        String[] routes = {"E 2", "S 2", "W 1"};

        공원산책 park2 = new 공원산책();
        int[] solution = park2.solution(park, routes);
        System.out.println(Arrays.toString(solution));

    }
    public int[] solution(String[] park, String[] routes) {
        int startRow = 0;
        int startColumn = 0;


        int rowSize = park.length;
        int columnSize = 0;



        // 시간 복잡도 차원에서 너무 더러운 코드다..
        // 아래 for문을 통해 startRow, startColumn의 값을 초기화
        for (int i = 0; i < rowSize; i++) {
            String row = park[i];
            columnSize = row.length();

            if (row.contains("S")) {
                startRow = i;
                char[] charArray = row.toCharArray();

                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == 'S') {
                        startColumn = j;
                    }
                }
            }
        }







        for (String route : routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            for (String s : park) {
                if (!s.contains("X") || direction.equals("E") && startColumn + distance < columnSize) {
                    startColumn += distance;
                }
            }
//            else if (direction.equals("W") && startColumn - distance >= 0) {
//                startColumn -= distance;
//            } else if (direction.equals("N") && startRow - distance >= 0) {
//                startRow -= distance;
//            } else if (direction.equals("S") && startRow + distance < rowSize) {
//                startRow += distance;
//            }
        }
        int[] answer = {startRow, startColumn};
        

        return answer;
    }

}
