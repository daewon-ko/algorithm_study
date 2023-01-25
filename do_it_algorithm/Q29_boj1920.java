package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q29_boj1920 {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i= 0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        // 찾아야하는 숫자의 개수
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<m; i++){
            boolean find = false;
            int wanted = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = data.length-1;
            while (start<=end){
                int midIndex = (start+end)/2;
                // mid의 인덱스의 실제 value값
                int midValue = data[midIndex];
                if(midValue>wanted)
                    end= midIndex-1;
                else if(midValue<wanted)
                    start= midIndex+1;
                else{
                    find =true;
                    break;
                }

            }
            if(find) System.out.println(1);
            else System.out.println(0);
        }





    }

}

