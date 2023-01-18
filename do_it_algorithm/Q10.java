package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q10 {
    public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());

                int[] arr = new int[N];

                for (int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                StringBuilder sb = new StringBuilder();
                ArrayDeque<DequeNode> deque = new ArrayDeque<>();

                for (int i = 0; i < N; i++) {
                    DequeNode number = new DequeNode(i, arr[i]);

                    while (!deque.isEmpty() && deque.peekLast().value > number.value) {
                        deque.removeLast();
                    }

                    if (!deque.isEmpty() && deque.peekFirst().index <= i - L) {
                        deque.removeFirst();
                    }

                    deque.offer(number);
                    sb.append(deque.peekFirst().value).append(" ");
                }

                System.out.println(sb.toString());
            }
        }


        class DequeNode {
            public int index;
            public int value;

            public DequeNode(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }


