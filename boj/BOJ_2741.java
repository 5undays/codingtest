package boj;

import java.util.Scanner;

/**
 * N찍기
 * https://www.acmicpc.net/problem/2741
 */
public class BOJ_2741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
