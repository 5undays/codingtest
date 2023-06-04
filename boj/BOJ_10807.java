package boj;

import java.util.Scanner;

/**
 * 개수 세기
 * https://www.acmicpc.net/problem/10807
 */
public class BOJ_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
