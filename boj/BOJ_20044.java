package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Project Teams
 * https://www.acmicpc.net/problem/20044
 */
public class BOJ_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, arr[i] + arr[n * 2 - i - 1]);
        }
        System.out.println(answer);
    }
}
