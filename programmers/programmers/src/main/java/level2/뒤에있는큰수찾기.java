package programmers.programmers.src.main.java.level2;

import java.util.Arrays;

public class 뒤에있는큰수찾기 {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        뒤에있는큰수찾기 a = new 뒤에있는큰수찾기();
        int[] result = a.solution(numbers);
        Arrays.stream(result).forEach(i -> System.out.printf(i+" "));

    }


    public int[] solution(int[] numbers) {
        int size = numbers.length-1;
        int[] answer = new int[size+1];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                while (numbers[j - 1] > numbers[j]) {

                    if(j ==numbers.length-1){
                        break;
                    }
                    j++;

                }
                if (j >= numbers.length - 1) {
                    answer[i] = -1;
                    break;
                }else {
                    answer[i] = numbers[j];
                    break;
                }

            }
        }

        return answer;
    }
}

class 뒤에있는큰수찾기Re{
    static int n;
    static boolean [] visited;
    static int [] result;
    public int solution(int[] numbers) {
        n = numbers.length;
        int start = 0;
        visited = new boolean[n];
        result = new int[n];


        backtracking(start, numbers);
    }

    public void backtracking(int depth, int [] numbers) {
        int max = Integer.MIN_VALUE;

        if (depth == n) {

            return;
        }

        for (int i = depth; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                max = Math.max(max, result[i]);
//                backtracking(i + 1, numbers);
            }

        }
    }
}
