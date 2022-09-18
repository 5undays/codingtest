package boj;

import java.util.Scanner;

/**
 * X보다 작은 수
 * https://www.acmicpc.net/problem/10871
 */
public class BOJ_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            if (m < x) {
                sb.append(m).append(" ");
            }
        }
        sc.close();
        System.out.println(sb);
    }
}
