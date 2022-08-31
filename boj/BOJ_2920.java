package boj;

import java.util.Scanner;

/**
 * 음계
 * https://www.acmicpc.net/problem/2920
 */
public class BOJ_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < 8; i++) {
            if (answer == "descending" && arr[i] > arr[i - 1]) {
                answer = "mixed";
                break;
            } else if (answer == "ascending" && arr[i] < arr[i - 1]) {
                answer = "mixed";
                break;
            }
            if (arr[i] < arr[i - 1]) {
                answer = "descending";
            } else if (arr[i] > arr[i - 1]) {
                answer = "ascending";
            }
        }
        System.out.println(answer);
    }
}
