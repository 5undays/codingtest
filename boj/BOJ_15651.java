package boj;

import java.util.Scanner;

/**
 * N과 M(3)
 * https://www.acmicpc.net/problem/15651
 */
public class BOJ_15651 {
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        go(0, m);
        System.out.println(sb.toString());
    }

    public static void go(int index, int m) {
        if (index == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            go(index + 1, m);
        }
    }
}
