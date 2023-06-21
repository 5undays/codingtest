package boj;

import java.util.Scanner;

/**
 * 코딩은 체육과목 입니다
 * https://www.acmicpc.net/problem/25314
 */
public class BOJ_25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("long ".repeat(n / 4) + "int");
    }
}
