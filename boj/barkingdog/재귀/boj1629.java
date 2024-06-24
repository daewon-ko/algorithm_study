package boj.barkingdog.재귀;
import java.util.Scanner;
public class boj1629 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();

            System.out.println(POW(a, b, c));

            scanner.close();
        }

        public static long POW(long a, long b, long m) {
            if (b == 1) return a % m;
            long val = POW(a, b / 2, m);
            val = val * val % m;
            if (b % 2 == 0) return val;
            return val * a % m;
        }
    }


