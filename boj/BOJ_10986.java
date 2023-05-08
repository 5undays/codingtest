package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나머지 합
 * https://www.acmicpc.net/problem/10986
 */
public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        long[] mod = new long[m];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] = (arr[i] + arr[i - 1]) % m;
            mod[(int) arr[i]]++;
        }

        long answer = mod[0];
        for (int i = 0; i < m; i++) {
            long k = mod[i];
            answer += k * (k - 1) / 2;
        }

        System.out.println(answer);
    }
}
