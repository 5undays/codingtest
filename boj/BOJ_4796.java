package boj;

import java.util.Scanner;

/**
 * 캠핑
 * https://www.acmicpc.net/problem/4796
 */
public class BOJ_4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        while(true) {
            int l = sc.nextInt(); // L일동안만 사용
            int p = sc.nextInt(); // 캠핑장을 연속하는 P일 중
            int v = sc.nextInt(); // V일짜리 휴가
            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            System.out.printf("Case %d: %d\n", answer++, v / p * l + Math.min(v % p, l));
        }
    }
}
