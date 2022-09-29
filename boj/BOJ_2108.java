package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 통계학
 * https://www.acmicpc.net/problem/2108
 */
public class BOJ_2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        sc.close();
        Arrays.sort(arr);

        int count = 0;
        int max = -1;

        int mod = arr[0];
        boolean check = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
                mod = arr[i];
                check = true;

            } else if (count == max && check) {
                mod = arr[i];
                check = false;
            }
        }

        System.out.println(Math.round(sum / n)); // 산술 평균
        System.out.println(arr[(n - 1) / 2]);
        System.out.println(mod);
        System.out.println(arr[n - 1] - arr[0]);
    }
}
