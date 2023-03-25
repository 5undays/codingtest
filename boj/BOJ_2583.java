package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 */
public class BOJ_2583 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int m;
    static int n;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for (int j = lx; j < rx; j++) {
                for (int w = ly; w < ry; w++) {
                    map[w][j] = 1;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    dfs(i, j);
                    arr.add(depth + 1);
                    depth = 0;
                }
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append("\n");
        for (int x : arr) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                    depth++;
                }
            }
        }
    }

}
