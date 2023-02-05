package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수들의 합 7
 * https://www.acmicpc.net/problem/2268
 */
public class BOJ_2268 {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        tree = new long[n * 4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (oper == 1) { // modify
                modify(1, n, 1, a, b);
            } else { // sum
                if (a >= b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                sb.append(sum(1, n, 1, a, b)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void modify(int start, int end, int node, int index, long value) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        modify(start, mid, node * 2, index, value);
        modify(mid + 1, end, node * 2 + 1, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}