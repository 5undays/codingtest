package boj;

import java.util.Scanner;

/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */
public class BOJ_1182 {

    static int n, s, answer, sum = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 수열 개수
        s = sc.nextInt(); // 수열의 합
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 수열
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int i, int sum) {
        if (i == n)
            return;
        if (s == arr[i] + sum) {
            answer++;
        }
   
        dfs(i + 1, sum);
        dfs(i + 1, sum + arr[i]);

    }
}
