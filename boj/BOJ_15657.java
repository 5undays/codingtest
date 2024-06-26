package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M(8)
 * https://www.acmicpc.net/problem/15657
 */
public class BOJ_15657 {
    static int[] data = new int[10];
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data, 0, n);
        go(0, 0);
        System.out.println(sb.toString());
    }

    private static void go(int index, int start) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(data[a[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            a[index] = i;
            go(index + 1, i);
        }
    }
}
