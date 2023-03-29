package boj;

import java.util.Scanner;

/**
 * 동전 0
 * https://www.acmicpc.net/problem/11047
 */
public class BOJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            answer += k / a[i];
            k %= a[i];
        }
        System.out.println(answer);
    }
}
