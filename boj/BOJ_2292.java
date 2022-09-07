package boj;

import java.util.Scanner;

/**
 * 벌집
 * https://www.acmicpc.net/problem/2292
 */
public class BOJ_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int a = 1;
        int answer = 1;
        while (a < n) {
            a = a + (6 * answer);
            answer++;
        }
        System.out.println(answer);
    }
}
