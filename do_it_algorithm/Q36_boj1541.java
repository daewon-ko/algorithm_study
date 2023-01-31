package do_it_algorithm;

import java.util.Scanner;

// 문제 조건이 정확히 이해가 안 가지만 시간관계상 일단 단순암기 진행
public class Q36_boj1541 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        //-기호를 기준으로 자른다.
        String[] str = example.split("-");
        for(int i= 0; i<str.length; i++){
            int temp = mySum(str[i]);
            if( i == 0 )
                answer = answer +temp; // 가장 앞에 있는 값만 더함.
            else
                answer = answer - temp; // 뒷부분들은 더한 값들을 뺀다.
        }
        System.out.println(answer);

    }
    static int mySum(String a){
        int sum = 0;
        // "[+}" 기준으로 잘린다는 것이 이해가 가지 않음.
        String tmp[] = a.split("\\+");
        for(int i = 0; i<tmp.length; i++){
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}
