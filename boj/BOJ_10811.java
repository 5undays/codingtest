package boj;

import java.util.Scanner;

/**
 * 바구니 뒤집기
 * https://www.acmicpc.net/problem/10811
 */
public class BOJ_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        while (m-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            for (int k = 0; k <= (j - i) / 2; k++) {
                int temp = arr[j - k - 1];
                arr[j - k - 1] = arr[i + k - 1];
                arr[i + k - 1] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
