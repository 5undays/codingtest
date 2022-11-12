package boj;

import java.util.Scanner;

/**
 * 전자레인지
 * https://www.acmicpc.net/problem/10162
 */
public class BOJ_10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = 0, b = 0, c = 0;
        while (t >= 10) {
            if (t >= 300) {
                a += t / 300;
                t %= 300;
            }
            if (t >= 60) {
                b += t / 60;
                t %= 60;
            }
            if (t >= 10) {
                c += t / 10;
                t %= 10;
            }
        }

        if (t != 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b + " " + c);
        }
    }
}
