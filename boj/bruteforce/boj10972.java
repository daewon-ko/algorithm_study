package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 다음순열
 */
public class boj10972 {
    static int n;
    static boolean[] visited;
    static List<Integer> before = new ArrayList<>();
    static List<Integer> after = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            before.add(Integer.parseInt(st.nextToken()));
        }

        func(0, 1);


    }

    public static void func(int depth, int start) {
        if (depth == n) {

            boolean flag = true;
//
//            for (int i = 0; i < before.size(); i++) {
//
//                if(!before.get(i).equals(after.get(i))){
//                    flag = false;
//                }
//            }

            if (flag) {
                for (int i = 0; i < n; i++) {
                    System.out.print(after.get(i) + " ");
                }
            }
            System.out.println();

            return;

        }


<<<<<<< Updated upstream
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
=======
        for (int i = start; i <=n; i++) {

            if(!visited[i]){
>>>>>>> Stashed changes
                visited[i] = true;
                after.add(i);
                func(depth + 1, start);
                after.remove(after.size() - 1);
                visited[i] = false;

            }
        }
    }
}


class boj10972_Re {
    static int[] arr;
    static int n;

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
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else
            System.out.println("-1");


    }

    public static boolean permutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j =arr.length -1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(arr, i-1, j);

        int k = arr.length-1;
        while (i < k) {
            swap(arr,i++, k--);
        }
        return true;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;

    }
}
