package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 단어 수학
 * https://www.acmicpc.net/problem/1339
 */
public class BOJ_1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] alphabet = new int[26];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String k = sc.next();
            for (int j = 0; j < k.length(); j++) {
                char c = k.charAt(j);
                alphabet[c - 'A'] += Math.pow(10, (k.length() - 1) - j);
            }
        }

        Arrays.sort(alphabet);

        for (int i = 25; i > 16; i--) {
            answer += alphabet[i] * (i - 16);
        }

        System.out.println(answer);
    }
}
