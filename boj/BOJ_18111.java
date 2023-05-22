package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트
 * https://www.acmicpc.net/problem/18111
 */
public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int min = 0, max = 256;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(map[i][j], min);
                max = Math.max(map[i][j], max);
            }
        }

        int seconds = 1000000000;
        int height = 0;
        for (int h = min; h <= max; h++) {
            int remove = 0;
            int add = 0;
            int block = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] < h) {
                        add += h - map[i][j];
                        block -= h - map[i][j];
                    } else if (map[i][j] > h) {
                        remove += map[i][j] - h;
                        block += map[i][j] - h;
                    }
                }
            }

            if (block < 0) {
                continue;
            }

            int time = remove * 2 + add;
            if (time <= seconds && h >= height) {
                seconds = time;
                height = h;
            }
        }

        System.out.println(seconds + " " + height);
    }
}
