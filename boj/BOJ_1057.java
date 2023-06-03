package boj;

import java.util.Scanner;

/**
 * 토너먼트
 * https://www.acmicpc.net/problem/1057
 */
public class BOJ_1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int answer = 0;
        while (a != b) {
            a -= a / 2;
            b -= b / 2;
            answer++;
        }
        System.out.println(answer == 0 ? -1 : answer);
    }
}
