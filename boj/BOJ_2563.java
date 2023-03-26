package boj;

import java.util.Scanner;

/**
 * 색종이
 * https://www.acmicpc.net/problem/2563
 */
public class BOJ_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[100][100];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0;j < 100; j++) {
                if (map[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
