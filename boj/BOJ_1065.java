package boj;

import java.util.Scanner;

/**
 * 한수
 * https://www.acmicpc.net/problem/1065
 */
public class BOJ_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int answer = 0;

        if (n < 100) {
            answer = n;
        } else {
            answer = 99;
            for (int i = 100; i <= n; i++) {

                int hun = i / 100; // 백의 자릿수
				int ten = (i / 10) % 10; // 십의 자릿수
				int one = i % 10;

                if ((hun - ten) == (ten - one)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}