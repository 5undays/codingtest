package boj;

import java.util.Scanner;

/**
 * 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class BOJ_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int number = i;
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            if (sum + i == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}
