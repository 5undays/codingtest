package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (12)
 * https://www.acmicpc.net/problem/15666
 */
public class BOJ_15666 {
    static int[] data;
    static boolean[] visited = new boolean[10];
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        go(0, 0);
        System.out.println(sb);
    }

    private static void go(int depth, int index) {
        if (depth == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        int x = 0;
        for (int i = index; i < n; i++) {
            if (x != data[i] ) {
                x = data[i];
                arr[depth] = data[i];
                go(depth + 1, i);
            }
        }
    }
}
