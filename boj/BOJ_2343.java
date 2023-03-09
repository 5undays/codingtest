package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 기타 레슨
 * https://www.acmicpc.net/problem/2343
 */
public class BOJ_2343 {
    static int max = 0;
    static int min = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            max += time[i];
            min = Math.max(min, time[i]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            int current = 0;
            for (int i = 0; i < n; i++) {
                if (current + time[i] > mid) {
                    current = 0;
                    count++;
                }
                current += time[i];
            }

            if (current != 0) {
                count++;
            }

            if (count <= m) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}
