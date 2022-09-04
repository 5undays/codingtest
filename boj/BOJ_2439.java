package boj;

import java.util.Scanner;

/**
 * 별찍기
 * https://www.acmicpc.net/problem/2439
 */
public class BOJ_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(" ");
            }
            for (int e = 0; e < i; e++) {
                sb.append("*");
            }
            sb.append("\n");
            answer.append(sb);
        }
        System.out.println(answer);
    }
}
