package boj;

import java.util.Scanner;

/**
 * 기찍 N
 * https://www.acmicpc.net/problem/2742
 */
public class BOJ_2742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        while (n > 0) {
            System.out.println(n--);
        }
    }
}
