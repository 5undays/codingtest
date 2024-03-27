package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 입국심사
 * https://www.acmicpc.net/problem/3079
 */
public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 입국심사대
        int m = Integer.parseInt(st.nextToken()); // 친구 명수

        int[] station = new int[n];
        for (int i = 0; i < n; i++) {
            station[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(station);

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int k = m / station[i];
            m -= k;
            answer = k * station[i];
            if (m == 0) {
                break;
            }
        }
        System.out.println(answer);
    }
}
