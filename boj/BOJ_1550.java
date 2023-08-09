package boj;

import java.util.Scanner;

/**
 * 16진수
 * https://www.acmicpc.net/problem/1550
 */
public class BOJ_1550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Integer.parseInt(s, 16));
    }
}
