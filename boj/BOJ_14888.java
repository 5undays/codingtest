package boj;

import java.util.Scanner;

/**
 * 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */
public class BOJ_14888 {
    static int n;
    static int[] arr;
    static int[] oper = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = -Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            oper[i] = sc.nextInt();
        }
        backtracking(1, arr[0]);
        System.out.print(max + "\n" + min);
    }

    private static void backtracking(int depth, int result) {
        if (depth > n - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        if (oper[0] > 0) {
            oper[0] -= 1;
            backtracking(depth + 1, result + arr[depth]);
            oper[0] += 1;
        }
        if (oper[1] > 0) {
            oper[1] -= 1;
            backtracking(depth + 1, result - arr[depth]);
            oper[1] += 1;
        }
        if (oper[2] > 0) {
            oper[2] -= 1;
            backtracking(depth + 1, result * arr[depth]);
            oper[2] += 1;
        }
        if (oper[3] > 0) {
            oper[3] -= 1;
            backtracking(depth + 1, result / arr[depth]);
            oper[3] += 1;
        }
    }
}
