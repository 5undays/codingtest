package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연구소
 * https://www.acmicpc.net/problem/14502
 */
public class BOJ_14502 {
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        newMap = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);
        System.out.println(answer);

    }

    private static int getCount() {
        newMap =  new int[n][m];
        visited = new boolean[n][m];
        // 바이러스 전염
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    newMap[i][j] = 1;
                }
                if (map[i][j] == 2 && !visited[i][j]) {
                    newMap[i][j] = 2;
                    dfs(i, j);
                }
            }
        }

        // 안전영역 크기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    newMap[nx][ny] = 2;
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void backtracking( int depth) {
        if (depth == 3) {
            int count = getCount();
            answer = Math.max(count, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
