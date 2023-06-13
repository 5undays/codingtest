package boj;

import java.util.Scanner;

/**
 * 하얀 칸
 * https://www.acmicpc.net/problem/1100
 */
public class BOJ_1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            String s = sc.next();
            int k = 0;
            if (i % 2 != 0) {
                k = 1;
            }

            for (int j = k; j < s.length(); j += 2) {
                if (s.charAt(j) == 'F') {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
