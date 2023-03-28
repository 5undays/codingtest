package boj;

import java.util.Scanner;

/**
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class BOJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[101];
        dp[0] = dp[1] = dp[2] = 1;
        for (int i = 3; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(dp[n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
