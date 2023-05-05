package boj;

import java.util.Scanner;

/**
 * 알파벳 개수
 * https://www.acmicpc.net/problem/10808
 */
public class BOJ_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb);
    }
}
