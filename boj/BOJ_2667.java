package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class BOJ_2667 {
    static int[][] map;
    static int n;
    static int[] nx = { 0, 0, -1, 1 };
    static int[] ny = { 1, -1, 0, 0 };
    static int[][] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && check[i][j] == 0) {
                    dfs(i, j, ++cnt);
                }
            }
        }

        int[] answer = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] != 0) {
                    answer[check[i][j] - 1] += 1;
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(cnt); // 총 단지 수
        for (int i = 0; i < cnt; i++) {
            System.out.println(answer[i]); // 단지 별 아파트 개수
        }
    }

    private static void dfs(int x, int y, int cnt) {
        check[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int dx = x + nx[i];
            int dy = y + ny[i];
            if (0 <= dx && dx < n && 0 <= dy && dy < n && map[dx][dy] == 1 && check[dx][dy] == 0) {
                dfs(dx, dy, cnt);
            }
        }
    }
}
