package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬의 개수
 * https://www.acmicpc.net/problem/4963
 */
public class BOJ_4963 {
    static int[] dx = {0, -1, 1, 0, 1, 0, -1, -1, 1};
    static int[] dy = {0, -1, 1, 1, 0, -1, 0, 1, -1};
    static int[][] group;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int b = sc.nextInt();
            int a = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            group = new int[a][b];
            map = new int[a][b];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (group[i][j] == 0 && map[i][j] == 1) {
                        dfs(i, j, ++answer, a, b);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    /**
     * 섬의 그룹 번호 설정
     * @param x     현재 x축 위치
     * @param y     현재 y축 위치
     * @param number     현재 그룹 번호
     * @param u     x축 범위
     * @param w     축 범위
     */
    public static void dfs(int x, int y, int number, int u, int w) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int px = p.x;
            int py = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx >= 0 && nx < u && ny >= 0 && ny < w && group[nx][ny] == 0 && map[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    group[nx][ny] = number;
                }
            }
        }
    }
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

