package boj;

import java.util.Scanner;

/**
 * N과 M(3)
 * https://www.acmicpc.net/problem/15651
 */
public class BOJ_15651 {
    static StringBuffer sb = new StringBuffer();
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
        System.out.println(sb.toString());
    }

    static boolean[] c = new boolean[10];

    public static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
        }

        if (index <= n) {
            for (int i = 1; i <= n; i++) {
                a[index] = i;
                go(index + 1, n, m);

            }
        }
    }
}
