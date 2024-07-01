package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (11)
 * https://www.acmicpc.net/problem/15665
 */
public class BOJ_15665 {
    static int n, m;
    static int[] arr;
    static int[] data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        data = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        go(0);
        System.out.println(sb);
    }

    public static void go(int depth) {
        if (depth == m) {
            for (int x : data) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        int x = 0;
        for (int i=0; i<n; i++) {
            if (x != arr[i]) {
                x = arr[i];
                data[depth] = arr[i];
                go(depth + 1);
            }
        }
    } 
}
