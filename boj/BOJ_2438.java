package boj;

import java.util.Scanner;

/**
 * 별 찍기 -1
 * https://www.acmicpc.net/problem/2438
 */
public class BOJ_2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int m = i;
            while (m-- > 0) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
