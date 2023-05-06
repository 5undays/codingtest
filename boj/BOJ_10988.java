package boj;

import java.util.Scanner;

/**
 * 팰린드롬인지 확인하기
 * https://www.acmicpc.net/problem/10988
 */
public class BOJ_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
