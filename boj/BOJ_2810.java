package boj;

import java.util.Scanner;

/**
 * 컵홀더
 * https://www.acmicpc.net/problem/2810
 */
public class BOJ_2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                if (i + 1 > n) break;
                if (s.charAt(i + 1) == 'L') {
                    i += 1;
                    count++;
                }
            }
        }

        if (count <= 1) {
            System.out.println(s.length());
        } else {
            System.out.println(s.length() - count + 1);
        }
    }
}
