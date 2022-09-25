package boj;

import java.util.Scanner;

/**
 * 다리 놓기
 * https://www.acmicpc.net/problem/1010
 */
public class BOJ_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[][] dp = bottomUp();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sb.append(dp[m][n]).append("\n");
        }

        sc.close();
        System.out.println(sb);
    }

    public static int[][] bottomUp() {
        int[][] dp = new int[30][30];
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp;
    }

    public static int combi(int i , int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == j || j == 0) {
            return 1;
        }
        return combi(i - 1, j - 1, dp) + combi(i - 1, j, dp);
    }
}
