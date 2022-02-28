package boj;

import java.util.Scanner;

public class BOJ_11054 {

    // https://www.acmicpc.net/problem/11054
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];

        // 올림 차순 배열 길이
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; i--) {
                if (arr[i] > arr[j])
                    leftArr[i] = Math.max(leftArr[i], leftArr[j] + 1);
            }
        }

        // 내림 차순
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < arr.length; i++) {
                if (arr[i] > arr[j])
                    rightArr[i] = Math.max(rightArr[i], rightArr[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(leftArr[i] + rightArr[i], answer);
        }
        System.out.println(answer + 1);
    }
}
