package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM
 * https://www.acmicpc.net/problem/11399
 */
public class BOJ_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (n - i);
        }
        System.out.println(sum);
    }
}
