package boj;

import java.util.Scanner;

/**
 * 분산처리
 * https://www.acmicpc.net/problem/1009
 */
public class BOJ_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long result = a;
            b = b % 4 + 4;

            for (int i = 2; i <= b; i++) {
                result = (result * a) % 10;
            }

            if (result == 0)
                result = 10;

            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
