package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (12)
 * https://www.acmicpc.net/problem/15666
 */
public class BOJ_15666 {
    static int[] data;
    static int[] temp = new int[10];
    static int[] a = new int[10];
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        go(0);
        System.out.println(sb);
    }

    private static void go(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(temp[a[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            a[depth] = i;
            go(depth + 1);
        }
    }
}
