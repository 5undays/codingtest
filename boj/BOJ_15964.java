package boj;

import java.util.Scanner;

/**
 * 이상한 기호
 * https://www.acmicpc.net/problem/15964
 */
public class BOJ_15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println((a + b) * (a - b));
    }
}
