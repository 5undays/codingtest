package boj;

import java.util.Scanner;

/**
 * 어두운 굴다리
 * https://www.acmicpc.net/problem/17266
 */
public class BOJ_17266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 굴다리 길이
        int m = sc.nextInt(); // 가로등의 개수
        int[] x = new int[m]; // 가로등의 위치
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            int current = 0;
            for (int c : x) {
                int start = c - mid;
                int end = c + mid;
                if (current < start) { // cover 불가
                    break;
                } else {
                    current = end;
                }
            }
            if (n <= current) { // 모두 다 covered
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
