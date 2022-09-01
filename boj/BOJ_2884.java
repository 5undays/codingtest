package boj;

import java.util.Scanner;

/**
 * 알람시계
 * https://www.acmicpc.net/problem/2884
 */
public class BOJ_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); // 시
        int m = sc.nextInt(); // 분
        sc.close();
        m = m - 45;
        if (m < 0) {
            h--;
            m = 60 - Math.abs(m);
        }
        if (h < 0) {
            h = 23;
        }
        System.out.println(h + " " + m);
    }
}
