package boj;

import java.util.Scanner;

/**
 * 수열
 * https://www.acmicpc.net/problem/2491
 */
public class BOJ_2491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            if (arr[i - 1] >= arr[i]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.max(dp[i], dp2[i]));
        }
        System.out.println(answer + 1);
    }
}
