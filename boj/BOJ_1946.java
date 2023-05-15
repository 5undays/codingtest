package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 신입 사원
 * https://www.acmicpc.net/problem/1946
 */
public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());
                arr[score] = rank;
            }

            int temp = arr[1];
            int count = 1;

            for (int i = 2; i <= n ;i++) {
                if (temp >= arr[i]) {
                    temp = arr[i];
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
