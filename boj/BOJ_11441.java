package boj;

import java.util.Scanner;

/**
 * 합 구하기
 * https://www.acmicpc.net/problem/11441
 */
public class BOJ_11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        while (m-- > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt();
            sb.append(dp[j] - dp[i]).append("\n");
        }
        System.out.println(sb);
    }
}
