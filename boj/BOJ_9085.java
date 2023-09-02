package boj;

import java.util.Scanner;

/**
 * 더하기
 * https://www.acmicpc.net/problem/9085
 */
public class BOJ_9085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += sc.nextInt();
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
