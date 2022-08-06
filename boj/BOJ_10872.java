package boj;

import java.util.Scanner;

/**
 * 팩토리얼
 * https://www.acmicpc.net/problem/10872
 */
public class BOJ_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1; 
        for (int i = n; i-1 > 0; i--) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
