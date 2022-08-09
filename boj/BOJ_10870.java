package boj;

import java.util.Scanner;

/**
 * 피보나치 수 5
 * https://www.acmicpc.net/problem/10870
 */
public class BOJ_10870 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int answer = fibonacci(n);
        System.out.println(answer);
    }

    private static int fibonacci(int number) {
        if (number == 1)
            return 1;
        if (number == 0)
            return 0;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
