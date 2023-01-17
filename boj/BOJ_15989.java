package boj;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기 4
 * https://www.acmicpc.net/problem/15989
 */
public class BOJ_15989 {
    static int[][] dp = new int[10001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            solve(n);
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int n) {
        if (dp[n][3] > 0) {
            return;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                int sum = 0;
                if (j == 1) {
                    dp[i][j] = 1;
                    continue;
                } else {
                    for (int k = 1; k <= j; k++) {
                        sum += dp[i - j][k];
                    }
                    dp[i][j] = sum;
                }
            }
        }
    }
}
