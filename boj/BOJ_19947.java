package boj;

import java.util.Scanner;

/**
 * 투자의 귀재 배주형
 * https://www.acmicpc.net/problem/19947
 */
public class BOJ_19947 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int y = sc.nextInt();
        int[] dp = new int[y + 1];
        dp[0] = h;
        for (int i = 1; i <= y; i++) {
            dp[i] = (int) (dp[i - 1] * 1.05);
            if (i >= 3) {
                dp[i] = (int) Math.max(dp[i], dp[i - 3] * 1.2);
            }
            if (i >= 5) {
                dp[i] = (int) Math.max(dp[i], dp[i - 5] * 1.35);
            }
        }
        System.out.println(dp[y]);

        // DFS
        //dfs(y, 0, h);
        //System.out.println(answer);
    }

    private static int dfs(int y, int year, int money) {
        if (year > y) return 0;
        if (year == y) return money;
        answer = Math.max(dfs(y, year + 1, (int) (money * 1.05)), answer);
        answer = Math.max(dfs(y, year + 3, (int) (money * 1.2)), answer);
        answer = Math.max(dfs(y, year + 5, (int) (money * 1.35)), answer);
        return answer;
    }
}
