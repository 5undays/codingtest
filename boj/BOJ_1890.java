package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프
 * https://www.acmicpc.net/problem/1890
 */
public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || (i == n - 1 && j == n - 1))
                    continue;
                int value = map[i][j];
                int down = value + i;
                int right = value + j;
                if (down < n) {
                    dp[down][j] = dp[down][j] + dp[i][j];
                }
                if (right < n) {
                    dp[i][right] = dp[i][right] + dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
