package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 */
public class BOJ_1987 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Character[][] alphabet;
    static int r, c;
    static boolean[] visited = new boolean[27];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabet = new Character[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                alphabet[i][j] = s.charAt(j);
            }
        }
        visited[alphabet[0][0] - 'A'] = true;
        backtracking(0, 0, 1);
        System.out.println(answer);
    }


    private static void backtracking(int x, int y, int depth) {
        answer = Math.max(depth, answer);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[alphabet[nx][ny] - 'A']) {
                    visited[alphabet[nx][ny] - 'A'] = true;
                    backtracking(nx, ny, depth + 1);
                    visited[alphabet[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}
