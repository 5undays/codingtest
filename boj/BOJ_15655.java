package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (6)
 * https://www.acmicpc.net/problem/15655
 */
public class BOJ_15655 {
    static StringBuffer sb = new StringBuffer();
    static int[] data;
    static int[] arr;
    static boolean[] c = new boolean[10];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        arr = new int[m];
        Arrays.sort(data);
        go(0, 0);
        System.out.println(sb.toString());
    }

    private static void go(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!c[i]) {
                c[i] = true;
                arr[depth] = data[i];
                go(depth + 1,i);
                c[i] = false;
            }
        }
    }
}
