package org.example.chap2.exercise;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExerciseQ4 {
    //b의 모든 요소를 a에 복사하는 메서드
    static void copy(int[] a, int[] b) {

        if (a.length == b.length) {
            for (int i = 0; i < b.length; i++) {
                a[i] = b[i];
            }
        }

        // Stream을 이용한 코드로 어떻게 할 수는 없을까?
        // 또는 List(?)의 copy메서드를 이용할 수는 없을까?
        if (a.length == b.length) {
            a = Arrays.copyOf(b, b.length);
        }        if (a.length == b.length) {
            for (int i = 0; i < b.length; i++) {
                a[i] = b[i];
            }
        }

        // 또는 Arrays의 copy메서드를 이용할 수는 없을까?
        if (a.length == b.length) {
            a = Arrays.copyOf(b, b.length);
        }

        // Stream을 이용한 코드로 어떻게 할 수는 없을까?
        // 하단과 같이 작성 가능

//        if (a.length == b.length) {
//            IntStream.range(0, b.length).forEach(i -> a[i] = b[i]);
//        }

    }
}
