package boj;

import java.util.Scanner;

/**
 * 구간 나누기 2
 * https://www.acmicpc.net/problem/13397
 */
public class BOJ_13397 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(arr, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isValid(int[] arr, int mid) {
        int cnt = 1;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];

            if (max - min > mid) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt <= m;
    }
}
