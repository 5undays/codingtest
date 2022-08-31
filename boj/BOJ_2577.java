package boj;

import java.util.Scanner;

/**
 * 숫자의 개수
 * https://www.acmicpc.net/problem/2577
 */
public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        String answer = (a * b * c) + "";

        int[] arr = new int[10];
        for (int j = 0; j < answer.length(); j++) {
            int idx = Integer.parseInt(answer.charAt(j) + "");
            arr[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
