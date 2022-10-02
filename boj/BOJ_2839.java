package boj;

import java.util.Scanner;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int answer = 0;
        while (n >= 0) {
            if (n % 5 == 0) {
                answer += n / 5;
                n = 0;
                break;
            }
            n -= 3;
            answer++;
        }
        System.out.println(n == 0 ? answer : -1);
    }
}
