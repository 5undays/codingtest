package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 탈출
 * https://www.acmicpc.net/problem/3055
 */
public class BOJ_3055 {
    static Map start;
    static int[][] hc;
    static int[][] wc;
    static char[][] map;
    static int r;
    static int c;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    static Queue<Map> wq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        hc = new int[r][c]; // 고슴도치 이동 횟수
        wc = new int[r][c]; // 물 이동 횟수
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '*') { // 물
                    wq.add(new Map(i, j));
                } else if (map[i][j] == 'S') {
                    start = new Map(i, j);
                }
            }
        }

        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    private static void bfs() {
        Queue<Map> hq = new LinkedList<>();
        hq.add(start);

        // 물
        while (!wq.isEmpty()) {
            Map wm = wq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = wm.x + dx[i];
                int ny = wm.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (wc[nx][ny] == 0 && map[nx][ny] == '.') {
                        wc[nx][ny] = wc[wm.x][wm.y] + 1;
                        wq.add(new Map(nx, ny));
                    }
                }
            }
        }

        // 고슴도치
        while (!hq.isEmpty()) {
            Map m = hq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != '*' && map[nx][ny] != 'X' && hc[nx][ny] == 0) {
                    int current = hc[m.x][m.y] + 1;
                    if (map[nx][ny] == 'D') { // 도착 지점
                        answer = Math.min(answer, current);
                        return;
                    } else if (wc[nx][ny] == 0 || wc[nx][ny] > current) { // 물이 없거나 물이 나중에 도착해서 고슴도치가 지나다닐수 있는 지역
                        hc[nx][ny] = current;
                        hq.add(new Map(nx, ny));
                    }
                }
            }
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
