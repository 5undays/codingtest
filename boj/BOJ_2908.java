package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상수
 * https://www.acmicpc.net/problem/2908
 */
public class BOJ_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            if (i < 4) {
                a.append(str.charAt(str.length() - i));
            } else if (i > 4) {
                b.append(str.charAt(str.length() - i));
            }
        }
        int answer = Math.max(Integer.parseInt(a.toString()), Integer.parseInt(b.toString()));
        System.out.println(answer);
    }
}
