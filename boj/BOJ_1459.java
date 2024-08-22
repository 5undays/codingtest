package boj;

import java.util.Scanner;

/**
 * 걷기
 * https://www.acmicpc.net/problem/1459
 */
public class BOJ_1459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long w = sc.nextInt(); // 한 블록 가는데 걸리는 시간
        long s = sc.nextInt(); // 대각선으로 한 블록을 가로지르는 시간

        long a = (x + y) * w;
        long b = 0;
        if ((x + y) % 2 == 0) {
            b = Math.max(x, y) * s;
        } else {
            b = (Math.max(x, y) - 1) * s + w;
        }
        long c = Math.min(x , y) * s + Math.abs(x - y) * w;
        System.out.println(Math.min(a, Math.min(b, c)));
    }
}
