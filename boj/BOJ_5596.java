package boj;

import java.util.Scanner;

/**
 * 시험 점수
 * https://www.acmicpc.net/problem/5596
 */
public class BOJ_5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score1 = 0;
        for (int i = 0; i < 4; i++) {
            score1 += sc.nextInt();
        }

        int score2 = 0;
        for (int i = 0; i < 4; i++) {
            score2 += sc.nextInt();
        }

        System.out.println(Math.max(score1, score2));
    }
}
