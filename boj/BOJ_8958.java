package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * OX 퀴즈
 * https://www.acmicpc.net/problem/8958
 */
public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int sum = 0;
            for (Byte b : br.readLine().getBytes()) {
                if (b == 'O') {
                    cnt++;
                    sum += cnt;
                } else {
                    cnt = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
