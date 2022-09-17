package boj;

import java.util.Scanner;

/**
 * 검증수
 * https://www.acmicpc.net/problem/2475
 */
public class BOJ_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(sc.nextInt(), 2);
        }
        sc.close();
        System.out.println(sum % 10);
    }
}
