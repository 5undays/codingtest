package boj;

import java.util.Scanner;

/**
 * 네 수
 * https://www.acmicpc.net/problem/10824
 */
public class BOJ_10824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(Long.parseLong(a + "" + b) + Long.parseLong(c + "" + d) );
    }
}
