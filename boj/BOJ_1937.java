package boj;

import java.util.Scanner;

/**
 * 욕심쟁이 판다
 * https://www.acmicpc.net/problem/1937
 */
public class BOJ_1937 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static int[][] map;
    static int n;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if (visited[x][y] != 0) return visited[x][y];
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[x][y] < map[nx][ny]) {
                visited[x][y] = Math.max(visited[x][y], dfs(nx, ny) + 1);
            }
        }
        return visited[x][y];
    }
}
