package boj;

import java.util.Scanner;

/**
 * A와 B
 * https://www.acmicpc.net/problem/12904
 */
public class BOJ_12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        StringBuilder t = new StringBuilder(sc.next());
        int answer = 0;
        while (true) {
            if (s.length() == t.length()) {
                if (s.toString().equals(t.toString())) {
                    answer = 1;
                }
                break;
            }
            char c = t.charAt(t.length() - 1);
            t = new StringBuilder(t.substring(0, t.length() - 1));
            if (c == 'B') {
                t = t.reverse();
            }
        }
        System.out.println(answer);
    }
}
