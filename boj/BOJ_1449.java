package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수리공 항승
 * https://www.acmicpc.net/problem/1449
 */
public class BOJ_1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물이 새는 곳의 개수
        int l = sc.nextInt(); //  테이프의 길이

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int answer = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (current <= arr[i]) {
                answer++;
                current = arr[i] + l;
            }
        }
        System.out.println(answer);
    }
}
