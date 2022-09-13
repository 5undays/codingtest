package boj;

import java.util.Scanner;

/**
 * 부녀회장이 될테야
 * https://www.acmicpc.net/problem/2775
 */
public class BOJ_2775 {
    public static int[][] apt = new int[15][15];

    public static void main(String[] args) {
        makeAPT();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(apt[k][n]);
        }
        sc.close();
    }

    private static void makeAPT() {
        for (int i = 0; i < 15; i++) {
            apt[0][i] = i; // 0 층 전체
            apt[i][1] = 1; // i층의 첫번째 호수
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }
    }
}
