package boj;

import java.util.Scanner;

/**
 * Hello Judge
 * https://www.acmicpc.net/problem/9316
 */
public class BOJ_9316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("Hello World, Judge " + i + "!\n");
        }
        System.out.println(sb);
    }
}
