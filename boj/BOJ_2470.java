package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] answer = new int[2];
        int min = 0, max = n - 1, hap = Integer.MAX_VALUE;
        while (min < max) {
            int result = Math.abs(arr[min] + arr[max]);
            if (result < hap) {
                hap = result;
                answer[0] = arr[min];
                answer[1] = arr[max];
                if (result == 0) {
                    break;
                }
            }

            if (arr[min] + arr[max] < 0) {
                min += 1;
            } else {
                max -= 1;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
