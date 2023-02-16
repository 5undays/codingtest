package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 거북이
 * https://www.acmicpc.net/problem/8911
 */
public class BOJ_8911 {
    static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = 0, y = 0, minX = 0, minY = 0, maxX = 0, maxY = 0, direction = 0;
            String control = br.readLine();
            for (int i = 0; i < control.length(); i++) {
                char c = control.charAt(i);
                if (c == 'F') { // +1
                    x += dx[direction];
                    y += dy[direction];
                } else if (c == 'B') { // -1
                    x -= dx[direction];
                    y -= dy[direction];
                } else if (c == 'L') { // 왼쪽 회전
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction -= 1;
                    }
                } else if (c == 'R') { // 오른쪽 회전
                    if (direction == 3) {
                        direction = 0;
                    } else {
                        direction += 1;
                    }
                }

                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
            }
            sb.append(Math.abs(maxX - minX) * Math.abs(maxY - minY)).append("\n");
        }
        System.out.println(sb);
    }
}
