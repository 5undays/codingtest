package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 2
 * https://www.acmicpc.net/problem/12015
 */
public class BOJ_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (dp[answer - 1] < a[i]) {
                answer++;
                dp[answer - 1] = a[i];
            } else {
                int left = 0;
                int right = answer;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] < a[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = a[i];
            }
        }
        System.out.println(answer);
    }
}
