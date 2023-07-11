package boj;

import java.util.Scanner;

/**
 * 막대기
 * https://www.acmicpc.net/problem/17608
 */
public class BOJ_17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 1;
        int height = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (height < arr[i]) {
                answer += 1;
                height = arr[i];
            }
        }
        System.out.println(answer);
    }
}
