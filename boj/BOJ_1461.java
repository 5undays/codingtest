package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 도서관
 * https://www.acmicpc.net/problem/1461
 */
public class BOJ_1461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int minus = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0) {
                minus++;
            }
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < minus; i += m) {
            answer += Math.abs(arr[i] * 2);
        }

        for (int i = n - 1; i >= minus; i -= m) {
            answer += arr[i] * 2;
        }

        answer -= Math.max(Math.abs(arr[0]), Math.abs(arr[n - 1]));
        System.out.println(answer);
    }
}
