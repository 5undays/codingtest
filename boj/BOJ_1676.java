package boj;

import java.util.Scanner;

/**
 * 팩토리얼 0의 개수
 * https://www.acmicpc.net/problem/1676
 */
public class BOJ_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 5; i <= n; i *= 5) {
            answer += n / i;
        }
        System.out.println(answer);
    }
}
