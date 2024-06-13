package boj;

import java.util.Scanner;

/**
 * N과 M (2)
 * https://www.acmicpc.net/problem/15650
 */
public class BOJ_15650 {
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        go(0, 1);
        System.out.println(sb.toString());
    }

    public static void go(int depth, int start) {
        if (depth == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            go(depth + 1, i + 1);
        }
    }

}
