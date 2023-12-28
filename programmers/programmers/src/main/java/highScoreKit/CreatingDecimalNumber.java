package programmers.highScoreKit;

// 프로그래머스 소수 만들기 문제

import java.util.ArrayList;
import java.util.List;

public class CreatingDecimalNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] a = {1,2,3,4};
        solution.solution(a);

    }
}
    class Solution {
        public int solution(int[] nums) {
            int answer = -1;
            int cnt = 0;
            List<Integer> list = new ArrayList<>();


            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length-1; j++){
                    int result = nums[i] +nums[j] + nums[j+1];
                    if(!list.contains(result)){
                        list.add(result);
                    }
                }
            }

            for (int i = 0; i < Math.sqrt(list.size()); i++) {

                if (list.get(i) == 0) {
                    continue;
                }

                for (int j = i + i; j < list.size(); j += i) {
                    cnt++;
                }

            }


            answer = cnt;

            return answer;
        }
    }

