package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문서 검색
 * https://www.acmicpc.net/problem/1543
 */
public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int answer = 0;
        int index = 0;

        while (a.length() - b.length() + 1> index) {
            if (a.substring(index, index + b.length()).equals(b)) {
                answer++;
                index += b.length();
            } else {
                index++;
            }
        }
        System.out.println(answer);
    }
}
