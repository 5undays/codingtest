package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963 {
    static int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            int[][] group = new int[a][b];
            int[][] map = new int[a][b];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (group[i][j] == 0 && map[i][j] == 1) {
                        dfs(map, i, j, ++answer, group, a, b);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void dfs(int[][] map, int x, int y, int a, int[][] group, int u, int w) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int px = p.x;
            int py = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = px + dx[i];
                int ny = py + dy[y];
                if (nx >= 0 && nx < u && ny >= 0 && ny < w && group[nx][ny] == 0 && map[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    group[nx][ny] = a;
                }
            }
        }

    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
