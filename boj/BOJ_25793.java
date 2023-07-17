package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 초콜릿 피라미드
 * https://www.acmicpc.net/problem/25793
 */
public class BOJ_25793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] st = br.readLine().split(" ");
            long y = Math.min(Long.parseLong(st[0]), Long.parseLong(st[1]));
            long x = Math.max(Long.parseLong(st[0]), Long.parseLong(st[1]));

            if (y == 1) {
                sb.append(x + " " + (x-1));
            } else if (y == x) {
                sb.append(((y*(y+1)*(2*y+1))/6)*2 - y*y).append(" ");
                sb.append(((y*(y+1)*(2*y+1))/6)*2 - y*y - y);
            } else {
                sb.append(((y*(y+1)*(2*y+1))/6)*2 - y*y + (y*y)*(x-y)).append(" ");
                sb.append(((y*(y+1)*(2*y+1))/6)*2 - y*y - y + (y*y)*(x-y));
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
