package boj;

import java.util.Scanner;

/**
 * 블랙잭
 * https://www.acmicpc.net/problem/2798
 */
public class BOJ_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 개수
        int m = sc.nextInt(); // 값
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int e = j + 1; e < n; e++) {
                    int data = arr[i] + arr[j] + arr[e];
                    if (data == m) {
                        System.out.println(data);
                        System.exit(0);
                    }
                    if (data > answer && data < m) {
                        answer = data;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
