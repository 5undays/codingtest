package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 보석 상자
 * https://www.acmicpc.net/problem/2792
 */
public class BOJ_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        int min = 1;
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < m; i++) {
                count += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    count++;
                }
            }
            if (count > n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
