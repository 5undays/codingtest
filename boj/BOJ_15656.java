package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M(7)
 * https://www.acmicpc.net/problem/15656
 */
public class BOJ_15656 {
    static int n, m;
    static int[] data = new int[10];
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        arr = new int[m];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        go(0);
        System.out.println(sb.toString());
    }

    private static void go(int depth) {
        if (depth == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = data[i];
            go(depth + 1);
        }
    }
}
