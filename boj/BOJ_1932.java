package boj;

import java.util.Scanner;

/**
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */
public class BOJ_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        int answer = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][0] += triangle[i - 1][0];
                } else {
                    int left = triangle[i - 1][j - 1] + triangle[i][j];
                    int right = triangle[i - 1][j] + triangle[i][j];
                    triangle[i][j] = Math.max(left, right);
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        System.out.println(answer);
    }
}
