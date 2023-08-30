package boj;

import java.util.Scanner;

/**
 * 영수증
 * https://www.acmicpc.net/problem/5565
 */
public class BOJ_5565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();

        int total = 0;
        for (int i = 0; i < 9; i++) {
            total += sc.nextInt();
        }

        System.out.println(price - total);
    }
}
