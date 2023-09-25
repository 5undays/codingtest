package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int k = sc.nextInt();
        int r = sc.nextInt();
        int answer = 0;
        for (int i = 3; i > 0; i--) {
            answer += arr[i];
        }

        System.out.println(answer + Math.max(k, r));
    }
}
