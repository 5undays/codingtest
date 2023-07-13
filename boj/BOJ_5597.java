package boj;

import java.util.Scanner;

/**
 * 과제 안 내신 분..?
 * https://www.acmicpc.net/problem/5597
 */
public class BOJ_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            arr[sc.nextInt()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
