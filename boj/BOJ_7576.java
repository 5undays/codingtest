package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 토마토
 * https://www.acmicpc.net/problem/7576
 */
public class BOJ_7576 {

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static boolean[][] check;
    static int[][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        map = new int[m][n];
        check = new boolean[m][n];
        distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], -1);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new Pair(i, j));
                    distance[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 0 && distance[nx][ny] == -1) {
                    q.add(new Pair(nx, ny));
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (answer < distance[i][j]) {
                    answer = distance[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && distance[i][j] == -1) {
                    answer = -1;
                }
            }
        }

        System.out.println(answer);
    }

}