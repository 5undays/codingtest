package boj;

import java.util.Scanner;
/**
 * 피보나치 수 2
 * https://www.acmicpc.net/problem/2748
 */
public class BOJ_2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] fibonacci = new long[91];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < 91; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println(fibonacci[n]);
    }   
}
