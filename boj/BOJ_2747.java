package boj;

import java.util.Scanner;

/**
 * 피보나치 수
 * https://www.acmicpc.net/problem/2747
 */
public class BOJ_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibonacci = new int[46];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < 46; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println(fibonacci[n]);
    }
}
