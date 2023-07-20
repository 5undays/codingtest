package boj;

import java.util.Scanner;

/**
 * 사파리월드
 * https://www.acmicpc.net/problem/2420
 */
public class BOJ_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(Math.abs(n - m));
    }
}
