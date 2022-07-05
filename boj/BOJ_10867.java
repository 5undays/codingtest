package boj;

import java.util.Scanner;

/**
 * 중복 빼고 정렬하기
 * https://www.acmicpc.net/problem/10867
 */
public class BOJ_10867 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] data = new boolean[2001];
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            data[arr[i] + 1000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                sb.append(i - 1000).append(" ");
            }
        }
        System.out.println(sb);
    }
}
