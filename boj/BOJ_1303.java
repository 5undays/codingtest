package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 전쟁 - 전투
 * https://www.acmicpc.net/problem/1303
 */
public class BOJ_1303 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[j][i] = s.charAt(j);
            }
        }
        int W = 0;
        int B = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'W') {
                        W += Math.pow(bfs(i, j, 'W'), 2);
                    } else {
                        B += Math.pow(bfs(i, j, 'B'), 2);
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }

    private static int bfs(int x, int y, char c) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            answer++;
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == c) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return answer;
    }
}
