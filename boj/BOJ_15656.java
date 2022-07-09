package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M(7)
 * https://www.acmicpc.net/problem/15656
 */
public class BOJ_15656 {

    static int[] data = new int[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data, 0, n);
        System.out.println(go(0, n, m));
    }

    private static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb1.append(data[a[i]]);
                if (i != m - 1) {
                    sb1.append(" ");
                }
            }
            sb1.append("\n");
            return sb1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            a[index] = i;
            sb.append(go(index + 1, n, m));
        }

        return sb;
    }
}
