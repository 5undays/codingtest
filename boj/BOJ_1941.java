package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 소문난 칠공주
 * https://www.acmicpc.net/problem/1941
 */
public class BOJ_1941 {
    static int[][] map = new int[5][5];
    static boolean[] visited = new boolean[25];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'Y') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }
        }
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static boolean validation() {
        boolean result = false;
        int temp = 0;
        Queue<Map> q = new LinkedList<>();
        boolean[][] check = new boolean[5][5];
        boolean[][] check_q = new boolean[5][5];

        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                int x = i / 5;
                int y = i % 5;
                check[x][y] = true;
                if (temp == 0) {
                    check_q[x][y] = true;
                    q.add(new Map(x, y));
                    temp++;
                }
            }
        }

        int count = 1;
        while (!q.isEmpty()) {
            Map m = q.poll();
            if (count == 7) {
                result = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];
                if (nx >= 0 && ny >= 0 && ny < 5 && nx < 5) {
                    if (check[nx][ny] && !check_q[nx][ny]) {
                        check_q[nx][ny] = true;
                        q.add(new Map(nx, ny));
                        count++;
                    }
                }
            }
        }
        return result;
    }

    private static void backtracking(int idx, int depth) {
        if (depth == 7) {
            int count = 0;
            for (int i = 0; i < 25; i++) {
                if (visited[i]) {
                    int x = i / 5;
                    int y = i % 5;
                    if (map[x][y] == 2) {
                        count++;
                    }
                }
            }
            if (count >= 4) {
                if (validation()) {
                    answer++;
                }
            }
        }

        for (int k = idx; k < 25; k++) {
            if (visited[k]) {
                continue;
            }
            visited[k] = true;
            backtracking(k, depth + 1);
            visited[k] = false;
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
