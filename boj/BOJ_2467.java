package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 용액
 * https://www.acmicpc.net/problem/2467
 */
public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int max = n - 1, min = 0;
        long hap = Long.MAX_VALUE;
        long[] answer = new long[2];
        while (min < max) {
            long mid = Math.abs(arr[max] + arr[min]);
            if (hap > mid) {
                hap = mid;
                answer[0] = arr[min];
                answer[1] = arr[max];
                if (mid == 0) {
                    break;
                }
            }

            if (arr[max] + arr[min] < 0) {
                min += 1;

            } else {
                max -= 1;

            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
