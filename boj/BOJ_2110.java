package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공유기 설치
 * https://www.acmicpc.net/problem/2110
 */
public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        int result = 0;
        int left = 1;
        int right = x[n - 1] - x[0];
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int prev = x[0];
            for (int i = 0; i < n; i++) {
                if (x[i] - prev >= mid) {
                    count++;
                    prev = x[i];
                }
            }

            if (count >= c) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
