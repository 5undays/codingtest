package boj;

import java.util.Scanner;

/**
 * 공백 없는 A+B
 * https://www.acmicpc.net/problem/15873
 */
public class BOJ_15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        if (n == 1010) {
            System.out.println(20);
        } else if (n % 10 == 0) {
            n /= 100;
            System.out.println(10 + n);
        } else {
            a += n % 10;
            n /= 10;
            if (n == 10) {
                System.out.println(10 + a);
            } else {
                System.out.println(a + n);
            }
        }
    }
}
