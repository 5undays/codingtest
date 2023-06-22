package boj;

import java.util.Scanner;

/**
 * 문자열
 * https://www.acmicpc.net/problem/1120
 */
public class BOJ_1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    count++;
                }
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }
}
