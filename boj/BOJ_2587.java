package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 대표값2
 * https://www.acmicpc.net/problem/2587
 */
public class BOJ_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        System.out.println((sum / 5) + "\n" + arr[2]);
    }
}
