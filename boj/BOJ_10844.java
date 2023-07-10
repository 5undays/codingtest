package boj;

import java.util.Scanner;

/**
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */
public class BOJ_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[101][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer % 1000000000);
    }
}
