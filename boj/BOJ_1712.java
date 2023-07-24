package boj;

import java.util.Scanner;

/**
 * 손익분기점
 * https://www.acmicpc.net/problem/1712
 */
public class BOJ_1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 고정 비용
        int b = sc.nextInt(); // 가변 비용
        int c = sc.nextInt(); // 가격

        if (b >= c) {
            System.out.println(-1);
        } else {
            System.out.println(a / (c - b) + 1);
        }
    }
}
