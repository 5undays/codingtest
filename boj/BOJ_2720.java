package boj;

import java.util.Scanner;

/**
 * 세탁소 사장 동혁
 * https://www.acmicpc.net/problem/2720
 */
public class BOJ_2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int quarter = 0, dime = 0, nickel = 0, penny = 0;
            int c = sc.nextInt();
            if (c / 25 != 0) {
                quarter = c / 25;
                c %= 25;
            }

            if (c / 10 != 0) {
                dime = c / 10;
                c %= 10;
            }

            if (c / 5 != 0) {
                nickel = c / 5;
                c %= 5;
            }

            penny = c;
            sb.append(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }
        System.out.println(sb);
    }
}
