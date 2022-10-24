package boj;

import java.util.Scanner;

/**
 * 침투
 * https://www.acmicpc.net/problem/13565
 */
public class BOJ_13565 {
    static int width = 0;
    static int height = 0;
    static boolean[][] check;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        height = m;
        width = n;
        check = new boolean[m][n];
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String x = sc.next();
            for (int j = 0 ; j < n; j++) {
                map[i][j] = Integer.parseInt(x.charAt(j)+"");
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }
        System.out.println("NO");
    }

    private static void dfs(int x, int y) {
        if (x >= 0 && y >= 0 && x < height && y < width && !check[x][y] && map[x][y] == 0) {
            if (x == height - 1) {
                System.out.println("YES");
                System.exit(0);
            }
            check[x][y] = true;
            dfs(x, y + 1);
            dfs(x + 1, y);
            dfs(x, y -1);
            dfs(x-1, y);
        }
    }
}
