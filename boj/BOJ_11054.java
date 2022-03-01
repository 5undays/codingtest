package boj;

import java.util.Scanner;

public class BOJ_11054 {

    // https://www.acmicpc.net/problem/11054
    public static void main(String args[]) {
        BOJ_11054 boj_11054 = new BOJ_11054();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] leftArr = boj_11054.LongIncreseSequece(arr); // 올림 차순 배열 
        int[] rightArr = boj_11054.LongDecreseSequence(arr); // 내림 차순 배열

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(leftArr[i] + rightArr[i], answer);
        }
        System.out.println(answer + 1);
    }

    private int[] LongIncreseSequece(int[] arr) {
        int[] leftArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    leftArr[i] = Math.max(leftArr[i], leftArr[j] + 1);
            }
        }
        return leftArr;
    }

    private int[] LongDecreseSequence(int[] arr) {
        int[] rightArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j])
                    rightArr[i] = Math.max(rightArr[i], rightArr[j] + 1);
            }
        }
        return rightArr;
    }
}
