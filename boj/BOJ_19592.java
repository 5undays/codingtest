package boj;

import java.util.Scanner;

/**
 * 장난감 경주
 * https://www.acmicpc.net/problem/19592
 */
public class BOJ_19592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 개수
        while (t-- > 0) {
            int n = sc.nextInt(); // 참가자 수
            int x = sc.nextInt(); // 트랙의 길이
            int y = sc.nextInt(); // 부스터 속도

            double min = x;
            for (int i = 0; i < n - 1; i++) {
                int v = sc.nextInt();
                min = Math.min(min, x / v);
            }

            int v = sc.nextInt();

            // 부스터를 쓰지않아도 빠른 경우
            if (min > 1.0 * x / v) {
                System.out.println(0);
                continue;
            }

            int left = 0;
            int right = y;

            while (true) {
                int mid = (left + right) / 2;
                if (left > right) {
                    break;
                }
                double booster = 1 + 1.0 * (x - mid) / v;
                if (booster >= min) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 부스터를 써도 이기지 못하는 경우
            if (left > y) {
                System.out.println(-1);
            } else {
                System.out.println(left);
            }
        }
    }
}
