package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길
 * https://www.acmicpc.net/problem/1520
 */
public class BOJ_1520 {
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }
        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (visited[x][y] != -1) {
            return visited[x][y];
        }
        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (map[nx][ny] < map[x][y]) {
                    visited[x][y] = visited[x][y] + dfs(nx, ny);
                    dfs(nx, ny);
                }
            }
        }
        return visited[x][y];
    }
}
