package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10973 {
    static int n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (permutation(arr)) {
            for (int i = 0; i < n; i++) {
                System.out.printf(arr[i]+" ");
            }
        } else System.out.println(-1);

    }

    public static boolean permutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i] > arr[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j= arr.length - 1;
        // i이후는 오름차순으로 정렬되어있음
        // i이후 중 가장 작은 것이 j가 됨
        while (arr[i - 1] < arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        int k = arr.length - 1;

        while (i < k) {
            swap(arr, i++, k--);

        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
