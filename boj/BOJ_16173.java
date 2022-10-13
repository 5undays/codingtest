package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 점프왕 쩰리 (Small)
 * https://www.acmicpc.net/problem/16173
 */
public class BOJ_16173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean[][] check = new boolean[n][n];
        Queue<Map> q = new LinkedList<>();
        q.add(new Map(0, 0));
        while (!q.isEmpty()) {
            Map m = q.poll();
            if (m.x >= 0 && m.x < n && m.y >= 0 && m.y < n) {
                if (map[m.x][m.y] == -1) {
                    System.out.println("HaruHaru");
                    System.exit(0);
                }
                if (!check[m.x][m.y] && map[m.x][m.y] != -1) {
                    check[m.x][m.y] = true;
                    q.add(new Map(m.x + map[m.x][m.y], m.y));
                    q.add(new Map(m.x, m.y + map[m.x][m.y]));
                }
            }
        }
        System.out.println("Hing");
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
