package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 안전 영역
 * https://www.acmicpc.net/problem/2468
 */
public class BOJ_2468 {
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max = 0;
        visited = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int k = max; k >= 0; k--) {
            int result = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        bfs(i, j, k);
                        result++;
                    }
                }
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j, int max) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] m = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = m[0] + dx[k];
                int y = m[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (map[x][y] > max && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

    }
}
