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

        boolean check = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j][0] = Integer.parseInt(st.nextToken());
                if (box[i][j][0] == 1) {
                    q.add(new int[] {i, j, 0});
                } else if (box[i][j][0] == 0) {
                    check = false;
                }
            }
        }

        if (check) {
            int answer = 0;
            while (!q.isEmpty()) {
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];
                int z = xy[2];

                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];
                    if (nx >= 0 && ny >= 0 && nz >= 0 && box[nx][ny][nz] == 1) {
                        box[nx][ny][nz] = 1;
                        q.add(new int[] {nx, ny, nz});
                    }
                    answer++;
                }
            }

            if (validate()) {
                System.out.println(answer);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(0);
        }
    }

    private static boolean validate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
