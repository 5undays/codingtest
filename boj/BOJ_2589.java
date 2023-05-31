package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 보물섬
 * https://www.acmicpc.net/problem/2589
 */
public class BOJ_2589 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static char[][] map;
    static int l;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[l][w];
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L') {
                    visited = new int[l][w];
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < l && ny < w && visited[nx][ny] == 0 && map[nx][ny] == 'L') {
                    visited[nx][ny] = visited[current[0]][current[1]] + 1;
                    q.add(new int[]{nx, ny});
                    result = Math.max(result, visited[nx][ny] - 1);
                }
            }
        }
        return result;
    }
}
