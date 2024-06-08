package boj;

import java.util.Scanner;

/**
 * 팩토리얼 2
 * https://www.acmicpc.net/problem/27433
 */
public class BOJ_27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
    private static long factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }
}
