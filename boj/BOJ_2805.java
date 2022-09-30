package boj;

import java.util.Scanner;

/**
 * 나무 자르기
 * https://www.acmicpc.net/problem/2805
 */
public class BOJ_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 첫째 줄에 나무의 수
        int m = sc.nextInt(); // 상근이가 집으로 가져가려고 하는 나무의 길이
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        sc.close();
        int min = 0;
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (double a : arr) {
                if (a - mid > 0) {
                    sum += a - mid;
                }
            }

            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}