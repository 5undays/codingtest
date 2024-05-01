package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 입국심사
 * https://www.acmicpc.net/problem/3079
 */
public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken()); // 입국심사대
        long m = Integer.parseInt(st.nextToken()); // 친구 명수

        long[] station = new long[(int)n];
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            station[i] = Long.parseLong(br.readLine());
            min = Math.min(min, station[i]);
            max = Math.max(max, station[i]);
        }

        max *= m;

        while (min <= max) {
            long mid = (max + min) / 2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / station[i];
                if (count > m) { break; }
            }

            if (count < m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
