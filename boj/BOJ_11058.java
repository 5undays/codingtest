package boj;

import java.util.Scanner;

/**
 * 크리보드
 * https://www.acmicpc.net/problem/11058
 */
public class BOJ_11058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {
            for (int j = 3; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        System.out.println(dp[n]);
    }
}
