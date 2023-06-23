package boj;

import java.util.Scanner;

/**
 * 2007년
 * https://www.acmicpc.net/problem/1924
 */
public class BOJ_1924 {
    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        for (int i = 1; i < m; i++) {
            d += month[i];
        }
        System.out.println(week[d % 7]);
    }
}
