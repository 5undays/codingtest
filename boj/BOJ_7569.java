package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */
public class BOJ_7569 {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] box;
    static int m;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[n][m][h];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int z = xy[0];
            int x = xy[1];
            int y = xy[2];

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0
                        && nx < n && ny < m && nz < h) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = box[z][x][y] + 1;
                        q.add(new int[] {nz, nx, ny});
                    }
                }
            }
        }

        System.out.println(validate());
    }

    private static int validate() {
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        return result - 1;
    }
}
