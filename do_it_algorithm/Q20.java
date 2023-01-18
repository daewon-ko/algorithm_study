package do_it_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//boj 2751
public class Q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
