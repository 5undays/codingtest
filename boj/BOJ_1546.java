package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 평균
 * https://www.acmicpc.net/problem/1546
 */
public class BOJ_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Double[] score = new Double[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextDouble();
        }
        sc.close();

        double sum = 0;
        Arrays.sort(score);
        for (int i = 0; i < n; i++) {
            sum += (score[i] / score[n - 1]) * 100;
        }
        System.out.println(sum / n);
    }
}
