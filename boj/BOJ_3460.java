package boj;

import java.util.Scanner;

/**
 * 이진수
 * https://www.acmicpc.net/problem/3460
 */
public class BOJ_3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            String str = Integer.toBinaryString(n);
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '1') {
                    sb.append(str.length() - i - 1).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
