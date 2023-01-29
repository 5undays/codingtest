package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 데스노트
 * https://www.acmicpc.net/problem/2281
 */
public class BOJ_2281 {
    static int[] dp;
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        System.out.println(dfs(0));
    }

    private static int dfs(int index) {
        if (dp[index] < Integer.MAX_VALUE) {
            return dp[index];
        }
        int k = m - arr[index];
        for (int i = index + 1; i <= n && k >= 0; i++) {
            if (i == n) {
                dp[index] = 0;
                break;
            }
            dp[index] = Math.min(dp[index], (k * k) + dfs(i));
            k -= arr[i] + 1;
        }
        return dp[index];
    }
}
