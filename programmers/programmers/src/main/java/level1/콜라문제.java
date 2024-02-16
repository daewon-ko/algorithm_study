package level1;

public class 콜라문제 {
    /**
     * 하단의 코드는 시간초과가 발생한다.
     * 이유는? n의 범위가 100만까지인데, 백만회 연산은 가능하지 않나? 1억번만 초과하지 않는다면?
     */
    public int solution1(int a, int b, int n) {
        int answer = 0;
        /**
         *
         n보다 작은 수 중에서 a로 나눠떨어지는 가장 큰 수를 구한다
         -> 최대 공약수개념?
         */

        // a로 나눠떨어지고 i보다 작은 수 중에서 가장 큰 값이 maxDiv

        int maxDiv = n;
        int AfterMartCola = 0;
        int AfterTotalCola = 0;

        while (maxDiv > a) {

            int max = 0;

            for (int i = 1; i < maxDiv; i++) {
                if (i % a == 0 && max <= i) {
                    max = i;
                }
            }

            AfterMartCola += (max / a) * b;

            AfterTotalCola = n - max + AfterMartCola;

            maxDiv = AfterTotalCola;


        }


        answer = AfterMartCola;


        return answer;
    }

    /**
     * 똑같이 시간초과가 발생한다.
     * 어느 부분에서 시간초과가 나는거지? while문?
     */
    public int solution2(int a, int b, int n) {


        int answer = 0;


        // a로 나눠떨어지고 i보다 작은 수 중에서 가장 큰 값이 maxDiv

        int maxDiv = n - (n % a);
        int AfterMartCola;

        while (maxDiv >= a) {


            AfterMartCola = (maxDiv / a) * b;

            answer += AfterMartCola;

            maxDiv = n - maxDiv + AfterMartCola;

        }


        return answer;
    }


    /**
     * 정답풀이(내풀이)
     * 쓸데없는 변수 선언이 너무 많지 않았나 싶다.
     *
     * n을 저런 식으로 초기화하지 않고 다른 방법도 있었을텐데
     *
     */

    public int solution3(int a, int b, int n) {


        int answer = 0;


        int maxDiv = n - (n % a);
        int AfterMartCola = 0;
        int AfterTotalCola = 0;


        while (maxDiv >= a) {


            AfterMartCola = (maxDiv / a) * b;

            answer += AfterMartCola;

            AfterTotalCola = n - maxDiv + AfterMartCola;

            n = AfterTotalCola;

            maxDiv = n - (n % a);


        }


        return answer;
    }

    /**
     * 다른분 풀이
     *
     * 직관적이고 깔끔하다.
     */

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += b * (n / a);
            n = b * (n / a) + n % a;
        }

        return answer;
    }
}
