package boj;

import java.util.Scanner;

/**
 * 빗물
 * https://www.acmicpc.net/problem/14719
 */
public class BOJ_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = 1; i < w - 1; i++) {
            int left_max = 0, right_max = 0;
            for (int j = 0; j < w; j++) {
                if (j <= i) {
                    left_max = Math.max(left_max, arr[j]);
                } else {
                    right_max = Math.max(right_max, arr[j]);
                }
            }

            int compare = Math.min(left_max, right_max);
            if (arr[i] < compare) {
                answer += compare - arr[i];
            }
        }
        System.out.println(answer);
    }
}
