package boj.자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String direction = br.readLine();
            String[] words = direction.split(" ");
            if (words.length >= 2) {
                String command = words[0];
                String number = words[1];
                queue.offer(Integer.valueOf(number));
//                System.out.println(number);
            } else {
                if (direction.equals("pop")) {
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                } else if (direction.equals("size")) {
                    System.out.println(queue.size());
                } else if (direction.equals("empty")) {
                    System.out.println(queue.isEmpty() ? 1 : 0);
                } else if (direction.equals("front")) {
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                } else if (direction.equals("back")) {
                    System.out.println(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast());
                }
            }
        }
    }
}

