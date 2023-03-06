package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 트리의 부모찾기 문제
/*
1. DFS로 풀어야 하는 이유는?
2. 클래스를 따로 파지 않고 Generic을 Integer로 두는 이유는
   value 등의 가중치가 없기 떄문에?
 */
public class Q67_boj11725 {
    static ArrayList<Integer> [] tree;
    static boolean [] check;
    static int [] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        check = new boolean[n+1];
        answer = new int[n+1];

        for(int i=0; i<tree.length; i++){
            tree[i] =  new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }
        DFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(answer[i]);
        }

    }
    static void DFS(int num){
        check[num] = true;
        for(int i : tree[num]){
            if(!check[i]){
                answer[i] = num;
                DFS(i);
            }
        }
    }
}