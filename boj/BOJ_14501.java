package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */
public class BOJ_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Work> arr = new ArrayList<>();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();
            arr.add(new Work(t, p));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + arr.get(i).day; j <= n; j++) {
                dp[j] = Math.max(arr.get(i).cost + dp[i], dp[j]);
            }
        }
        System.out.println(dp[n]);
    }

    static class Work {
        int day;
        int cost;

        Work(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }
}
