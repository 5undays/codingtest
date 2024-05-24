package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주유소
 * https://www.acmicpc.net/problem/13305
 */
public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] oil = new long[n + 1];
        long[] arr = new long[n + 1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long current = oil[0];
        long answer = arr[1] * oil[0];
        for (int i = 1; i < n; i++) {
            if (current < oil[i]) {
                answer += current * arr[i + 1];
            } else {
                current = oil[i];
                answer += arr[i + 1] * current;
            }
        }
        System.out.println(answer);
    }
}
