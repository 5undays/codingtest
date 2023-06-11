package boj;

import java.util.Scanner;

/**
 * 영수증
 * https://www.acmicpc.net/problem/25304
 */
public class BOJ_25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sum += a * b;
        }

        if (sum == x) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
