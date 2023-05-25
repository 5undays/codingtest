package boj;

import java.util.Scanner;

/**
 * 뒤집기
 * https://www.acmicpc.net/problem/1439
 */
public class BOJ_1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = 0, t = 0;
        char prev = s.charAt(0);
        if (prev == '1') {
            k++;
        } else {
            t++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (s.charAt(i) == '1') {
                    k++;
                } else {
                    t++;
                }
            }
            prev = s.charAt(i);
        }
        System.out.println(Math.min(k, t));
    }
}
