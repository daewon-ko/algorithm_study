package org.example.chap2.exercise;

import java.util.Arrays;

public class ExerciseQ2 {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] reverseArray(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

        return arr;
    }
}
