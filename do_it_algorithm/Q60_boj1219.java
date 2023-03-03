package do_it_algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 세일즈맨의 고민( 이해 잘 안감 -> 추후 공부 필요)
public class Q60_boj1219 {
    static int n, m, sCity, eCity;
    static long distance[], cityMoney[];
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m];
        distance = new long[n];
        cityMoney = new long[n];
        // distance 배열을 왜 Min 값으로 채워야할까?
        // <- 변형된 벨만-포드 알고리즘이므로
        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        // cityMoney 값 할당
        for(int i=0; i<n; i++){
            cityMoney[i] = Integer.parseInt(st.nextToken());
        }
        distance[sCity] = cityMoney[sCity];

        for(int i=0; i<n+50; i++){
            for(int j=0; j<m; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int value = edges[j].value;
                if(distance[start] == Long.MIN_VALUE) continue;
                else if(distance[start] == Long.MAX_VALUE){
                    distance[end] = Long.MAX_VALUE;
                }else if(distance[end] < distance[start]+cityMoney[end]-value){
                    distance[end] = distance[start]+cityMoney[end]-value;
                }
                if(i>=n-1) distance[end] =Long.MAX_VALUE;
            }
        }
        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);



    }

    static class Edge {
        int start, end, value;

        Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}

