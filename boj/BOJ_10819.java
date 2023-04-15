package boj;

import java.util.Scanner;

/**
 * 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 */
public class BOJ_10819 {
    static int[] arr;
    static boolean[] visited;
    static int n, answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtracking(0, arr[i], 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    private static void backtracking(int depth, int prev, int sum) {
        if (depth == n - 1) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int current = arr[i];
                sum += Math.abs(prev - current);
                backtracking(depth + 1, current, sum);
                sum -= Math.abs(prev - current);
                visited[i] = false;
            }
        }
    }
}
