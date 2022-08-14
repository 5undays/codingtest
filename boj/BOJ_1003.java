package boj;

import java.util.Scanner;

/**
 * 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 */
public class BOJ_1003 {
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            fibonacci(number);
            sb.append(dp[number][0]).append(" ").append(dp[number][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }
}
