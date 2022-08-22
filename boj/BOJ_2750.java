package boj;

import java.util.Scanner;

/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
public class BOJ_2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        selectionSort(a);

        for (int x : a) {
            System.out.println(x);
        }
    }

    // 선택 정렬 - 오름차순
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 카운팅 정렬
    // private void countingSort(int[] arr) {
    //     int[] cntArr = new int[1001];
    //     for (int i = 0; i < arr.length; i++) {
    //         cntArr[i]++;
    //     }

    //     for (int i = 0; i < cntArr.length; i++) {
    //         if (cntArr[i] > 0) {
    //             System.out.println(i);
    //         }
    //     }
    // }
}
