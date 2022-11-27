package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 양 한마리... 양 두마리...
 * https://www.acmicpc.net/problem/11123
 */
public class BOJ_11123 {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Character[][] arr = new Character[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            Queue<Map> q = new LinkedList<>();
            int answer = 0;
            int[][] check = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (check[i][j] == 0 && arr[i][j] == '#') {
                        q.add(new Map(i, j));
                        answer++;
                        check[i][j] = 1;
                        while (!q.isEmpty()) {
                            Map m = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nr = m.x + dr[d];
                                int nc = m.y + dc[d];
                                if (nr < 0 || nr >= h || nc < 0 || nc >= w || arr[nr][nc] == '.' || check[nr][nc] == 1)
                                    continue;
                                check[nr][nc] = 1;
                                q.offer(new Map(nr, nc));
                            }
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
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
