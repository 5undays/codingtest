package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로탐색
 * https://www.acmicpc.net/problem/2178
 */
public class BOJ_2178 {
    static int[][] map;
    static boolean[][] check;
    static int[][] distance;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        sc.nextLine();
        check = new boolean[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0)); // 1,1 에서 출발하지만 물리적으론 0,0 으로 설정해줌
        check[0][0] = true;
        distance[0][0] = 1;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == false && map[nx][ny] == 1) {
                        q.add(new Pair(nx, ny));
                        distance[nx][ny] = distance[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(distance[n - 1][m - 1]);
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
