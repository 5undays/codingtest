package boj;

import java.util.Scanner;

/**
 * 주사위 세개
 * https://www.acmicpc.net/problem/2480
 */
public class BOJ_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int answer = 0;
        if (a == b && b == c) {
            answer = 10000 + (a * 1000);
        } else if (a == b) {
            answer = 1000 + (a * 100);
        } else if (b == c) {
            answer = 1000 + (b * 100);
        } else if (c == a) {
            answer = 1000 + (c * 100);
        } else {
            answer = Math.max(a, Math.max(b, c)) * 100;
        }

        System.out.println(answer);
    }
}
