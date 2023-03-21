package boj;

import java.util.Scanner;

/**
 * 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316
 */
public class BOJ_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            answer++;
            boolean[] alphabet = new boolean[26];
            alphabet[s.charAt(0) - 'a'] = true;
            for (int j = 1; j < s.length(); j++) {
                int c = (int) s.charAt(j) - 'a';
                if (s.charAt(j) != s.charAt(j - 1) && alphabet[c]) {
                    answer--;
                    break;
                }
                alphabet[c] = true;
            }
        }
        System.out.println(answer);
    }
}
