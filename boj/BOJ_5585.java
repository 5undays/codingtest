package boj;

import java.util.Scanner;

/**
 * 거스름돈
 * https://www.acmicpc.net/problem/5585
 */
public class BOJ_5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = 1000 - n;
        sc.close();
        int answer = 0;
        while (n > 0) {
            if (n / 500 > 0) {
                answer += n / 500;
                n = n % 500;
            } else if (n / 100 > 0) {
                answer += n / 100;
                n = n % 100;
            } else if (n / 50 > 0) {
                answer += n / 50;
                n = n % 50;
            } else if (n / 10 > 0) {
                answer += n / 10;
                n = n % 10;
            } else if (n / 5 > 0) {
                answer += n / 5;
                n = n % 5;
            } else {
                answer += n;
                n -= n;
            }
        }   
        System.out.println(answer);
    }
}
