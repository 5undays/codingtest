package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (6)
 * https://www.acmicpc.net/problem/15655
 */
public class BOJ_15655 {
    static StringBuffer sb = new StringBuffer();
    static int[] a = new int[10];
    static int[] data = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        go(0, n, m);
        System.out.println(sb.toString());
    }


    public static void go(int start, int n, int m) {
        if (start == m) {
            for (int i = 0; i < m; i++) {
                sb.append(data[a[i]]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            a[start] = i;
            go(start + 1, n, m);
        }
    }
}
