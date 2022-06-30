package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2751 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        arr = new int[n];
        // ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            // arr.add(sc.nextInt());
        }

        // Collections.sort(arr);

        countingSort();

        for (int x : arr) {
            sb.append(x).append("\n");
            // System.out.println(x);
        }
        System.out.println(sb);
    }

    private static void countingSort() {
        int[] cntArr = new int[2000001];
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i] + 1000000]++;
        }

        int reset = 0;

        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] > 0) {
                arr[reset++] = i - 1000000;
                // System.out.println(i - 1000000);
            }
        }
    }

}
