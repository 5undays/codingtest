package boj;

import java.util.Scanner;

/**
 * 외판원 순회 2
 * https://www.acmicpc.net/problem/10971
 */
public class BOJ_10971 {
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int start, int current, int cost) {
        if (isValid()) {
            if (arr[current][start] != 0) {
                answer = Math.min(answer, cost + arr[current][0]);
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i] && arr[current][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + arr[current][i]);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
