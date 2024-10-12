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
