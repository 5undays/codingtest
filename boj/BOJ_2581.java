package boj;

import java.util.Scanner;

/**
 * 소수
 * https://www.acmicpc.net/problem/2581
 */
public class BOJ_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0, min = 0;
        for (int i = m; i <= n; i++) {
            if (i == 1) continue;
            boolean even = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    even = true;
                    break;
                }
            }
            if (!even) {
                sum += i;
                if (min == 0) {
                    min = i;
                }
            }
        }
        if (min > 0) {
            System.out.println(sum + "\n" + min);
        } else {
            System.out.println(-1);
        }
    }
}
