package boj;

import java.util.Scanner;

/**
 * 한조서열정리하고옴ㅋㅋ
 * https://www.acmicpc.net/problem/14659
 */
public class BOJ_14659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    dp[i]++;
                } else {
                    break;
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
