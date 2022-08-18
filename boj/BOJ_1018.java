package boj;

import java.util.Scanner;

/**
 * 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 */
public class BOJ_1018 {
    static boolean[][] map;
    static int answer = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'W') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        // 시작 줄과 열 
        int s_row = n - 7;
        int s_col = m - 7;

        for (int i = 0; i < s_row; i++) {
            for (int j = 0; j < s_col; j++) {
                int count = find(i, j);
                answer = Math.min(count, answer);
            }
        }

        System.out.println(answer);
    }

    /**
     * 가장 적게 변동되는 갯수 찾기
     * @param s_row 시작 줄
     * @param s_col 시작 열
     * @return 변동되는 최소 개수
     */
    private static int find(int s_row, int s_col) {
        int count = 0;
        int e_row = s_row + 8;
        int e_col = s_col + 8;

        boolean check = map[s_row][s_col];
        for (int i = s_row; i < e_row; i++) {
            for (int j = s_col; j < e_col; j++) {
                if (map[i][j] == check) {
                    count++;
                }
                check = !check;
            }
            check = !check;
        }

        return Math.min(count, 64 - count);
    }
}
