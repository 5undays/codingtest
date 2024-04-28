package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 모음의 개수
 * https://www.acmicpc.net/problem/1264
 */
public class BOJ_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) {
                break;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a'
                        || s.charAt(i) == 'e'
                        || s.charAt(i) == 'i'
                        || s.charAt(i) == 'o'
                        || s.charAt(i) == 'u'
                        || s.charAt(i) == 'A'
                        || s.charAt(i) == 'E'
                        || s.charAt(i) == 'I'
                        || s.charAt(i) == 'O'
                        || s.charAt(i) == 'U') {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
