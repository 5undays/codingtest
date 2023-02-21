package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 음식물 피하기
 * https://www.acmicpc.net/problem/1743
 */
public class BOJ_1743 {
    static boolean[][] visited;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        visited = new boolean[n][m];
        map = new boolean[n][m];
        while (k-- > 0) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            map[r][c] = true;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j]) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }

}
