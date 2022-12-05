package boj;

import java.util.Scanner;

/**
 * 연속부분최대곱
 * https://www.acmicpc.net/problem/2670
 */
public class BOJ_2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        double answer = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] * arr[i - 1] >= arr[i]) {
                arr[i] = arr[i - 1] * arr[i];
            }
            answer = Math.max(answer, arr[i]);
        }
        System.out.println(String.format("%.3f", answer));
    }
}
