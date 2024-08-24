package programmers.programmers.src.main.java.level1;

import java.util.Arrays;

public class 공원산책 {
    public static void main(String[] args) {
        String[] park = {"S00", "0XX", "000"};
        String[] routes = {"E 2", "S 2", "W 1"};

        공원산책 park2 = new 공원산책();
        int[] solution = park2.solution2(park, routes);
        System.out.println(Arrays.toString(solution));

    }
//    public int[] solution(String[] park, String[] routes) {
//        int startRow = 0;
//        int startColumn = 0;
//
//
//        int rowSize = park.length;
//        int columnSize = 0;
//
//
//
//        // 시간 복잡도 차원에서 너무 더러운 코드다..
//        // 아래 for문을 통해 startRow, startColumn의 값을 초기화
//        for (int i = 0; i < rowSize; i++) {
//            String row = park[i];
//            columnSize = row.length();
//
//            if (row.contains("S")) {
//                startRow = i;
//                char[] charArray = row.toCharArray();
//
//                for (int j = 0; j < charArray.length; j++) {
//                    if (charArray[j] == 'S') {
//                        startColumn = j;
//                    }
//                }
//            }
//        }
//
//
//
//
//
//
//
//        for (String route : routes) {
//            String direction = route.split(" ")[0];
//            int distance = Integer.parseInt(route.split(" ")[1]);
//            for (String s : park) {
//                if (!s.contains("X") || direction.equals("E") && startColumn + distance < columnSize) {
//                    startColumn += distance;
//                }
//            }
////            else if (direction.equals("W") && startColumn - distance >= 0) {
////                startColumn -= distance;
////            } else if (direction.equals("N") && startRow - distance >= 0) {
////                startRow -= distance;
////            } else if (direction.equals("S") && startRow + distance < rowSize) {
////                startRow += distance;
////            }
//        }
//        int[] answer = {startRow, startColumn};
//
//
//        return answer;
//    }


    public int[] solution2(String[] park, String[] routes) {
        // 그래프의 세로열 길이 초기화
        int ySize = park.length;
        int xSize = 0;

        int startY = 0;
        int startX = 0;

        // Stream으로 변환을 어떻게 할까?
        for (int i = 0; i < park.length; i++) {
            String word = park[i];

            // 그래프의 가로열 길이 초기화
            xSize = word.length();

            if (word.contains("S")) {
                startY = i;
            }

            char[] charArr = word.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if ('S' == charArr[j]) {
                    startX = j;
                }
            }

        }


        for (String s : routes) {
            String direction = s.split(" ")[0];
            int num = Integer.parseInt(s.split(" ")[1]);

            park[startY].charAt(startX);

            if (direction.equals("E")) {
                int newX = startX + num;
                if (0 <= newX && newX < xSize) {

                    for (int i = startX; i < newX; i++) {
                        if (park[startY].charAt(i) == 'X') {
                            newX = startX;
                            break;
                        }
                    }

                    startX = newX;
                }


            } else if (direction.equals("W")) {
                int newX = startX - num;
                if (0 <= newX && newX < xSize) {
                    for (int i = startX; i > newX; i--) {
                        if (park[startY].charAt(i) == 'X') {
                            newX = startX;
                            break;
                        }
                    }
                    startX = newX;
                }


            } else if (direction.equals("S")) {
                int newY = startY + num;

                if (0 <= newY && newY < ySize) {
                    for (int i = startY; i < newY; i++) {
                        if (park[i].charAt(startX) == 'X') {
                            newY = startY;
                            break;
                        }
                    }
                    startY = newY;
                }


            } else if (direction.equals("N")) {
                int newY = startY - num;

                if (0 <= newY && newY < ySize) {
                    for (int i = startY; i > newY; i--) {
                        if (park[i].charAt(startX) == 'X') {
                            newY = startY;
                            break;
                        }
                    }
                    startY = newY;
                }


            }
        }

        return new int[]{startY, startX};


//        Arrays.stream(park)
//                .filter(p -> {
//                    if (p.contains("S")) {
//
//                    }
//
//                    char[] charArray = p.toCharArray();
//                    for (char c : charArray) {
//
//                    }
//                })

    }


}
