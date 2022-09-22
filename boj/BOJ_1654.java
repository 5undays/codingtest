package boj;

import java.util.Scanner;

/**
 * 랜선자르기
 * https://www.acmicpc.net/problem/1654
 */
public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] len = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            len[i] = sc.nextInt();
            if (max < len[i]) {
                max = len[i];
            }
        }
        sc.close();

        max++;

        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < len.length; i++) {
                cnt += len[i] / mid;
            }
            if (cnt < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
