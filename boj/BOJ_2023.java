package boj;

import java.util.Scanner;

/**
 * 신기한 소수
 * https://www.acmicpc.net/problem/2023
 */
public class BOJ_2023 {
    static int[] prime = {2, 3, 5, 7};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int p : prime) {
            dfs(p, n - 1);
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int number) {
        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int prime, int depth) {
        if (depth == 0) {
            sb.append(prime).append("\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            int number = prime * 10 + i;
            if (isPrime(number)) {
                dfs(number, depth - 1);
            }
        }
    }
}
