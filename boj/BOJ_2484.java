package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주사위 네개
 * https://www.acmicpc.net/problem/2484
 */
public class BOJ_2484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == b && b == c && c == d) {
                answer = Math.max(answer, 50000 + (a * 5000));
            } else if (a == b && b == c) { // d
                answer = Math.max(answer, 10000 + (a * 1000));
            } else if (b == c && c == d) { // a
                answer = Math.max(answer, 10000 + (b * 1000));
            } else if (a == b && b == d) { // c
                answer = Math.max(answer, 10000 + (d * 1000));
            } else if (a == d && a == c) { // b
                answer = Math.max(answer, 10000 + (c * 1000));
            } else if (a == d && b == c) {
                answer = Math.max(answer, 2000 + (a * 500) + (b * 500));
            } else if (a == c && b == d) {
                answer = Math.max(answer, 2000 + (a * 500) + (b * 500));
            } else if (a == b && c == d) {
                answer = Math.max(answer, 2000 + (a * 500) + (d * 500));
            } else if (a == b) {
                answer = Math.max(answer, 1000 + (a * 100));
            } else if (b == c) {
                answer = Math.max(answer, 1000 + (b * 100));
            } else if (c == d) {
                answer = Math.max(answer, 1000 + (c * 100));
            } else if (d == a) {
                answer = Math.max(answer, 1000 + (d * 100));
            } else if (a == c) {
                answer = Math.max(answer, 1000 + (a * 100));
            } else if (b == d) {
                answer = Math.max(answer, 1000 + (b * 100));
            } else {
                answer = Math.max(answer, Math.max(a ,Math.max(b, Math.max(c, d))) * 100);
            }
        }
        System.out.println(answer);
    }
}
