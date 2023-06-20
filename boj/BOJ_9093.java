package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */
public class BOJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] text = br.readLine().split(" ");
            for (int i = 0; i < text.length; i++) {
                for (int j = text[i].length() - 1; j >= 0; j--) {
                    sb.append(text[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
