package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈
 *
 */
public class BOJ_2636 {
    private static int a;
    private static int b;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, 1, -1, 0};
    private static int cheese = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[a][b];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int answer = 0;
        int oneHour = 0 ;
        while (cheese > 0) {
            oneHour = cheese;
            bfs();
            answer++;
        }
        System.out.println(answer + "\n" + oneHour);
    }

    private static void bfs() {
        visited = new boolean[a][b];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0 , 0});
        while (!q.isEmpty()) {
            int[] m = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = m[0] + dx[i];
                int y = m[1] + dy[i];

                if (x >= 0 && x < a
                        && y >= 0 && y < b
                        && !visited[x][y]) {
                    visited[x][y] = true;
                    if (map[x][y] == 1) {
                        map[x][y] = 0;
                        cheese--;
                    } else {
                        q.add(new int[] {x ,y});
                    }
                }
            }
        }
    }
}
