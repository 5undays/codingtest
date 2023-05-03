package boj;

import java.util.Scanner;

/**
 * K번째 수
 * https://www.acmicpc.net/problem/1300
 */
public class BOJ_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long min = 1;
        long max = k;
        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n , mid / i);
            }

            if (count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}
