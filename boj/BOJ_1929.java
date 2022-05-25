package boj;

import java.util.Scanner;

public class BOJ_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for (int i = M; i < N; i++) {
            if (is_prime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean is_prime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= number/2 ; i++) {
            if (number % i == 0) 
                return false;
        }
        return true;
    }
}
