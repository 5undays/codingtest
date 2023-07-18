package boj;

import java.util.Scanner;

/**
 * R2
 * https://www.acmicpc.net/problem/3046
 */
public class BOJ_3046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(s * 2 - r1);
    }
}
