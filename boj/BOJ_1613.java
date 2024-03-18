package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 역사
 * https://www.acmicpc.net/problem/1613
 */
public class BOJ_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수
        int k = Integer.parseInt(st.nextToken()); // 전후 관계의 개수

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = -1;
            map[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) { // mid
            for (int j = 1; j <= n; j++) { // 앞
                for (int v = 1; v <= n; v++) { // 뒤
                    if (map[j][v] == 0) {
                        if (map[j][i] == -1 && map[i][v] == -1) {
                            map[j][v] = -1;
                        } else if (map[j][i] == 1 && map[i][v] == 1) {
                            map[j][v] = 1;
                        }
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(map[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}
