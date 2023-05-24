package boj;

import java.util.Scanner;

/**
 * 행렬 곱셈
 * https://www.acmicpc.net/problem/2740
 */
public class BOJ_2740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int bm = sc.nextInt();
        int bk = sc.nextInt();
        int[][] arr1 = new int[bm][bk];
        for (int i = 0; i < bm; i++) {
            for (int j = 0; j < bk; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        int[][] answer = new int[n][bk];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bk; j++) {
                for (int k = 0; k < m; k++) {
                    answer[i][j] += arr[i][k] * arr1[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bk; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
