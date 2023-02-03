package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 소수&팰린드롬 수 중에서 최솟값 찾기
public class Q39_boj1747 {
    static int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
        어떻게 구할 수 있을까? N을 입력받으면 N보다 크면서 소수인 수 중에서
        '팰린드롬'을 만족하는 최솟값을 찾는게 문제의 요구사항이다.

        입력을 받는 형식은 뭐가 되었든 중요하지 않지만, N의 범위가 1,000,000까지이므로
        시간복잡도도 고려해야 할 것이다.

        1) 소수를 구하는 알고리즘은 앞선 문제들에서 살펴봤듯이, 이중 For문으로 Sqrt메서드를 이용한다.
        그렇지만, 앞선문제들과 달리 이 문제의 경우 입력값인 N이 시작값이지 숫자의 범위가 아니므로 이전과 같이
        활용이 불가하다. -> 응용하는 방법은 없을까?
        -> N의 범위가 백만이다 즉, 10의 7승!

        2) 문제에서 말하는 '팰린드롬'을 구현하는 방법은 무엇이 있을까? -> 투포인터? -> 어디서 배웠지? 정렬?
        -> 특정 숫자 m이 있을 때, 인덱스 i,j가 양끝에서부터 시작한다. 둘이 서로 만날 때 까지 반복문을 돌고,
        i==j 일떄 반복문을 탈출? and 반복문을 돌면서 해당 인덱스의 값들이 같은 지 확인해준다?

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 문제의 조건에서 n의 범위가 1~ 100만
        // n의 범위는 1000만까지여야 답이 통과됨 왜? 
        int[] A = new int[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        // A 배열 소수만들기
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j < A.length; j += i) {
                A[j] = 0;
            }
        }

//        int i = n;
//        while (true){
//            if(A[i]!=0){
//                if(pelendrom(A[i])){
//                    System.out.println(A[i]);
//                    break;
//                }
//            }
//            i++;
//        }


        // 내가 푼 풀이 왜 답이 안 나오지?

        for (int i = n; i < A.length; i++) {
            // A의 배열 중 소수인 것만 check
            if (A[i] != 0) {
                // 팰린드롬 구하기
                if (pelendrom(A[i])) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }

    }

    // 팰린드롬 구하는 메서드
    public static boolean pelendrom(int n) {
        char[] temp = String.valueOf(n).toCharArray();
        int start_index = 0;
        int end_index = temp.length - 1;
        while (start_index < end_index) {
            if (temp[start_index] != temp[end_index]) {
                return false;
            }
            start_index++;
            end_index--;
        }
        return true;
    }
}
