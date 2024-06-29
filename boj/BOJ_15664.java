package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (10)
 * https://www.acmicpc.net/problem/15664
 */
public class BOJ_15664 {
    static int[] data;
    static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    static int n,m;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        arr = new int[m];
        visited = new boolean[10001];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        go(0, 0);
        System.out.println(sb);
    }

    private static void go(int depth, int start) {
        if (depth == m) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        int k = 0;
        for (int i = start; i < n; i++) {
            if (k != data[i]) {
                k = data[i];
                arr[depth] = data[i];
                go(depth + 1, i + 1);
            }
        }
    }



}

