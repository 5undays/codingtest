package boj;

import java.util.Scanner;

/**
 * 에라토스테네스의 체
 * https://www.acmicpc.net/problem/2960
 */
public class BOJ_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    if (arr[j] == 0) {
                        count++;
                        arr[j] = 1;
                    }
                    if (count == k) {
                        System.out.println(j);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
