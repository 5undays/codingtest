package boj;

import java.util.Scanner;

/**
 * 날짜 계산
 * https://www.acmicpc.net/problem/1476
 */
public class BOJ_1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt(); // 지구 1~15
        int S = sc.nextInt(); // 태양 1~28
        int M = sc.nextInt(); // 달 1~19
        int e = 1, s = 1, m = 1;
        for (int i = 1;; i++) {
            if (e == E && s == S && m == M) {
                System.out.println(i);
                break;
            }

            e++;
            s++;
            m++;

            // 초기화
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }
    }
}
