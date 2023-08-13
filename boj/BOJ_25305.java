package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 커트라인
 * https://www.acmicpc.net/problem/25305
 */
public class BOJ_25305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[n - k]);
    }
}
