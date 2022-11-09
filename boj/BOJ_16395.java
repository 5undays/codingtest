package boj;

import java.util.Scanner;

/**
 * 파스칼의 삼각형
 * https://www.acmicpc.net/problem/16395
 */
public class BOJ_16395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(dfs(n, k));
    }

    private static int dfs(int n, int k) {
        if (k == 1) {
            return 1;
        } else if (k == n) {
            return 1;
        }
        return dfs(n - 1, k - 1) + dfs(n - 1, k);
    }
}
