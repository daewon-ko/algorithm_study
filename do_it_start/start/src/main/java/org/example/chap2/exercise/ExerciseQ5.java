package org.example.chap2.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ExerciseQ5 {
    static void rcopy(int[] a, int[] b) {
//        int[] reverseB = IntStream.range(0, b.length - 1).map(
//                i -> b[b.length - i - 1]
//        ).toArray();
//        a = reverseB;

        Integer[] copyArray = new Integer[b.length];
        for (int i : b) {
            copyArray[i] = b[i];
        }
        Arrays.sort(copyArray, Collections.reverseOrder());
    }


}
