package boj;

import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * A → B
 * https://www.acmicpc.net/problem/16953
 */
public class BOJ_16953 {
    static int answer = MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        dfs(a, b, 0);
        if (answer == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(long a, long b, int depth) {
        if (a > b) return;
        if (a == b) {
            answer = Math.min(depth + 1, answer);
            return;
        }

        dfs(a * 2, b, depth + 1);
        dfs(Long.parseLong(a+"1"), b, depth + 1);
    }
}
