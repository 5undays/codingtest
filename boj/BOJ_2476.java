package boj;

import java.util.Scanner;

/**
 * 주사위 게임
 * https://www.acmicpc.net/problem/2476
 */
public class BOJ_2476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == b && b == c) {
                answer = Math.max(answer, 10000 + (a * 1000));
            } else if (a == b) {
                answer = Math.max(answer, 1000 + (a * 100));
            } else if (a == c) {
                answer = Math.max(answer, 1000 + (a * 100));
            } else if (b == c) {
                answer = Math.max(answer, 1000 + (b * 100));
            } else {
                answer = Math.max(answer, Math.max(Math.max(a, b), c) * 100);
            }
        }
        System.out.println(answer);
    }
}
