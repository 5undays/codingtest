package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 센서
 * https://www.acmicpc.net/problem/2212
 */
public class BOJ_2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 센서의 개수
        int k = sc.nextInt(); // 집중국의 개수

        if (k >= n) {
            System.out.println(0);
            System.exit(0);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 센서의 거리 오름차순으로 정렬
        Arrays.sort(arr);

        int[] diff = new int[n - 1];
        // 센서의 거리만큼 재배열
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        // 거리의 차이만큼 오름차순으로 정렬
        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
