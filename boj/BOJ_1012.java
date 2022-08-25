package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 유기농 배추
 * https://www.acmicpc.net/problem/1012
 */
public class BOJ_1012 {
    static int[][] map;
    static boolean[][] visited;
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 개수
        while (t-- > 0) {
            m = sc.nextInt(); // 가로 길이
            n = sc.nextInt(); // 세로 길이
            int k = sc.nextInt(); // 배추 심은 위치 갯수
            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }
            int answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void dfs(int x, int y) {
        Queue<Map> q = new LinkedList<Map>();
        q.add(new Map(x, y));
        while (!q.isEmpty()) {
            Map spot = q.remove();
            int current_x = spot.x;
            int current_y = spot.y;
            if (current_x < m && current_y < n && current_x >= 0 && current_y >= 0) {
                if (map[current_x][current_y] == 1 && !visited[current_x][current_y]) {
                    visited[current_x][current_y] = true;
                    q.add(new Map(current_x, current_y + 1));
                    q.add(new Map(current_x + 1, current_y));
                    q.add(new Map(current_x - 1, current_y));
                    q.add(new Map(current_x, current_y - 1));
                }
            }
        }
    }
}

class Map {
    int x;
    int y;

    Map(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
