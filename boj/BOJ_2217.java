package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 로프
 * https://www.acmicpc.net/problem/2217
 */
public class BOJ_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] *= n - i;
            answer = Math.max(answer, arr[i]);
        }
        System.out.println(answer);
    }
}
