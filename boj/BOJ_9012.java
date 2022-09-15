package boj;

import java.util.Scanner;

/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class BOJ_9012 {

    public static boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        if (cnt == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            boolean result = isValid(sc.next());
            if (result == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
