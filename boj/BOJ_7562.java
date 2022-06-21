package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */
public class BOJ_7562 {
    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int l = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int xx = sc.nextInt();
            int yy = sc.nextInt();

            int[][] map = new int[l][l];
            for (int j = 0; j < l; j++) {
                Arrays.fill(map[j], -1);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            q.add(y);
            map[x][y] = 0;
            while (!q.isEmpty()) {
                int qx = q.remove();
                int qy = q.remove();
                for (int t = 0; t < dx.length; t++) {
                    int nx = qx + dx[t];
                    int ny = qy + dy[t];
                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && map[nx][ny] == -1) {
                        map[nx][ny] = map[qx][qy] + 1;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }

            System.out.println(map[xx][yy]);
        }
    }
}
