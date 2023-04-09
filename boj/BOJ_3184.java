package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 양
 * https://www.acmicpc.net/problem/3184
 */
public class BOJ_3184 {
    static Character[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int r;
    static int c;
    static int sheep = 0, wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new Character[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int sheep_total = 0, wolf_total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    sheep = 0; wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) {
                        sheep_total += sheep;
                    } else {
                        wolf_total += wolf;
                    }
                }
            }
        }


        System.out.println(sheep_total + " " + wolf_total);
    }

    private static void dfs(int x, int y) {
        if ('o' == map[x][y]) {
            sheep++;
        } else if ('v' == map[x][y]) {
            wolf++;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[nx][ny] && map[nx][ny] != '#') {
                    dfs(nx, ny);
                }
            }
        }
    }

}
