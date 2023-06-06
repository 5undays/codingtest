package boj;

import java.util.Scanner;

/**
 * TV 크기
 * https://www.acmicpc.net/problem/1297
 */
public class BOJ_1297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(); // 대각선 길이
        int h = sc.nextInt(); // 높이 비율
        int w = sc.nextInt(); // 너비 비율

        System.out.println((int) (d / Math.sqrt(h * h + w * w) * h) + " " + (int) (d / Math.sqrt(h * h + w * w) * w));
    }
}
