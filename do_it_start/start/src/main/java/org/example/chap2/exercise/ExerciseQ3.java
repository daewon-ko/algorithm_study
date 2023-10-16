package org.example.chap2.exercise;

public class ExerciseQ3 {
    // 배열의 모든 요소의 합계를 구하여 반환하는 메서드
    static int sumOf(int[] a) {
        int answer =0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i];
        }
        return answer;

    }
}
