import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main{


        public int[] solution(int []arr) {
            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList();

            for(int i = 0; i<arr.length; i++){
                queue.offer(arr[i]);
            }

            queue.offer(arr[0]);
            for(int i = 1; i<arr.length; i++){

                if(!queue.isEmpty() && queue.peek() == arr[i] ){
                    list.add(queue.poll());
                }

            }

            int[] answer = new int[list.size()];



            for(int i = 0; i<list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }

    public static void main(String [] args) throws IOException {
        int [] arr = {1,1,3,3,0,1,1};
        Main main = new Main();
        System.out.println(Arrays.toString(main.solution(arr)));

    }

}


class Solution {

}