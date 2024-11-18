package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16967 {


}

class boj16967Ref{

    static int h,w,x,y;
    static int [][] arr;
    static int [][] brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // arr,brr 초기화
        arr = new int[h][w];
        brr = new int[h + x][w + y];


        // brr  및 할당
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                brr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 겹치지 않는 부분 행부분 할당
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = brr[i][j];
            }
        }


        // 겹치지 않는 열 부분 할당
        for (int i = x; i < h; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = brr[i][j];
            }
        }

        // 겹치지 않는 부분 계산

        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                arr[i][j] = brr[i][j] - arr[i -x][j - y];
            }
        }


        for (int i = 0; i < h; i++) {
            for(int j= 0; j<w; j++){
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }



    }
}
