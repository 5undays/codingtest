package boj;

import java.util.Scanner;

/**
 * 세 수
 * https://www.acmicpc.net/problem/2985
 */
public class BOJ_2985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a + b == c) {
            System.out.printf("%d+%d=%d", a, b, c);
        } else if (a - b == c) {
            System.out.printf("%d-%d=%d", a, b, c);
        } else if (a * b == c) {
            System.out.printf("%d*%d=%d", a, b, c);
        } else if (a / b == c) {
            System.out.printf("%d/%d=%d", a, b, c);
        } else if (a == b + c) {
            System.out.printf("%d=%d+%d", a, b, c);
        } else if (a == b - c) {
            System.out.printf("%d=%d-%d", a, b, c);
        } else if (a == b * c) {
            System.out.printf("%d=%d*%d", a, b, c);
        } else if (a == b / c) {
            System.out.printf("%d=%d/%d", a, b, c);
        }
    }
}
