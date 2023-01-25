package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */
public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1])
                dp[i][i + 1] = true;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 2; j <= n; j++) {
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (dp[s][e]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        br.close();
        System.out.println(sb);

    }
}
