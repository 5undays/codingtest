package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 아기 상어 2
 * https://www.acmicpc.net/problem/17086
 */
public class BOJ_17086 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, 0, -1, 1};
    static int answer = 0;
    static int[][] map;
    static int[][] distance;
    static int w;
    static int h;
    static Queue<Map> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        distance = new int[n][m];
        q = new LinkedList<>();
        w = n;
        h = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new Map(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, distance[i][j]);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Map b = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = b.x + dx[i];
                int y = b.y + dy[i];
                if (x >= 0 && y >= 0 && x < w && y < h) {
                    if (distance[x][y] == 0 && map[x][y] == 0) {
                        distance[x][y] = distance[b.x][b.y] + 1;
                        q.add(new Map(x, y));
                    }
                }
            }
        }
    }


    static class Map {
        int x;
        int y;

        Map(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
