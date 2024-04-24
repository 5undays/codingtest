package boj;

import java.util.Scanner;

/**
 * 빙산
 * https://www.acmicpc.net/problem/2573
 */
public class BOJ_2573 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int n, m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            int count = getAreaCount();
            if (count == 0) {
                answer = 0;
                break;
            }
            if (count >= 2) {
                break;
            }
            map = meltMountain();
            answer++;
        }
        System.out.println(answer);
    }

    private static int[][] meltMountain() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int xk = i + dx[k];
                        int yk = j + dy[k];
                        if (map[xk][yk] == 0) {
                            count++;
                        }
                    }
                    newMap[i][j] = Math.max(map[i][j] - count, 0);
                }
            }
        }
        visited = new boolean[n][m];
        return newMap;
    }

    private static int getAreaCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] > 0)
                    dfs(nx, ny);
            }
        }
    }
}
