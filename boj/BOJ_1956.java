package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 운동
 * https://www.acmicpc.net/problem/1956
 */
public class BOJ_1956 {
    public static final int INF = 4000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                arr[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                for (int k = 1; k <= v; k++) {
                    if (k == j || k == i) continue;
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int answer = INF * 2;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (arr[i][j] == INF || arr[j][i] == INF) continue;
                if (i == j) {
                    answer = Math.min(answer, arr[i][j]);
                } else {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        if (answer == INF * 2) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
