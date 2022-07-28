package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스타트와 링크
 * https://www.acmicpc.net/problem/14889
 */
public class BOJ_14889 {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int idx, int depth) {
        if (depth == n / 2) { // 팀 조합 완성
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            visited[i] = true;
            backtracking(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void diff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += map[j][i] + map[i][j];
                }
            }
        }

        int val = Math.abs(startTeam - linkTeam);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        answer = Math.min(val, answer);
    }
}
