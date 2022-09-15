package boj;

import java.util.Scanner;

/**
 * 사칙연산
 * https://www.acmicpc.net/problem/10869
 */
public class BOJ_10869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(a + b + "\n" + (a - b) + "\n" + (a * b) + "\n" + (a / b) + "\n" + (a % b));
    }
}
