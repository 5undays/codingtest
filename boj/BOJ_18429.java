package boj;

import java.util.Scanner;

/**
 * 근손실
 * https://www.acmicpc.net/problem/18429
 */
public class BOJ_18429 {
    static int[] arr;
    static int k;
    static int n;
    static boolean visited[];
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 운동 일자
        k = sc.nextInt(); // 감소하는 무게
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int power) {
        if (depth == n - 1 && power >= 0) {
            answer++;
            return;
        }

        for (int i = 0 ; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (power + arr[i] - k >= 0) {
                    dfs(depth + 1, power + arr[i] - k);
                }
                visited[i] = false;
            }
        }
    }
}
