package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 묶기
 * https://www.acmicpc.net/problem/1744
 */
public class BOJ_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int minus = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] <= 0) {
                minus++;
            }
        }

        Arrays.sort(arr);

        int answer = 0;

        // 움수의 개수가 홀수 일때 가장 큰 마이너스 값은 더해준다
        if (minus % 2 != 0) {
            answer += arr[minus - 1];
        }

        // 마이너스 값은 짝수일때 곱해졌을때 큰 값을 만든다
        for (int i = 0; i < minus - 1; i += 2) {
            answer += arr[i] * arr[i + 1];
        }

        // 양수의 개수가 홀수 일때 가장 작은 값은 더해준다
        if ((n - minus) % 2 != 0) {
            answer += arr[minus];
        }

        // 양수가 개수가 짝수 일때는 값끼리 곱해준다
        for (int i = n - 1; i > minus; i -= 2) {
            answer += Math.max(arr[i] * arr[i - 1], arr[i] + arr[i - 1]);
        }


        System.out.println(answer);
    }
}
