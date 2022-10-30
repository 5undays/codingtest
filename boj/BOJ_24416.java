package boj;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 피보나치 수 1
 * https://www.acmicpc.net/problem/24416
 */
public class BOJ_24416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n) + " " + (n - 2));
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
