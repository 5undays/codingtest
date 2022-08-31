package boj;

import java.util.Scanner;

/**
 * 직각삼각형
 * https://www.acmicpc.net/problem/4153
 */
public class BOJ_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0)
                break;

            if (a * a == b * b + c * c) {
                System.out.println("right");
            } else if (b * b == a * a + c * c) {
                System.out.println("right");
            } else if (c * c == a * a + b * b) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

        sc.close();
    }
}
