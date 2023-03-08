package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 리프 노드의 개수 구하기
public class Q68_boj1068 {
    static ArrayList<Integer> tree[];
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        visited = new boolean[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else root = i;
        }

        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode == root){
            System.out.println(0);
        }else{
            DFS(root);
            System.out.println(answer);
        }


    }
    static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;
        for (int i : tree[number])
            if (visited[i] == false && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        if(cNode == 0){
            answer++;
        }
    }
    }


