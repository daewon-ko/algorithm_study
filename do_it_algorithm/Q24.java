package do_it_algorithm;

import java.util.*;
import java.io.*;

public class Q24{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}