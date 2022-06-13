package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15657 {
    static boolean[] c = new boolean[10];
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
        go(0, 0, n, m);
        System.out.println(sb.toString());
    }

    static StringBuilder sb = new StringBuilder();

    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(data[a[i]]);
                if (i != m) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        if (index < n) {
            for (int i = start; i < n; i++) {
                a[index] = i;
                go(index + 1, i, n, m);
            }
        }
    }
}
