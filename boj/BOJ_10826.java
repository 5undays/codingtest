package boj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 피보나치 수 4
 * https://www.acmicpc.net/problem/10826
 */
public class BOJ_10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            BigInteger[] fibonacci = new BigInteger[n + 1];
            fibonacci[0] = BigInteger.ZERO;
            fibonacci[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 2].add(fibonacci[i - 1]);
            }
            System.out.println(fibonacci[n]);
        }
    }
}
