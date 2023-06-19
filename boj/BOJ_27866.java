package boj;

import java.util.Scanner;

/**
 * 문자와 문자열
 * https://www.acmicpc.net/problem/27866
 */
public class BOJ_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = sc.nextInt();
        System.out.println(s.charAt(i - 1));
    }
}
