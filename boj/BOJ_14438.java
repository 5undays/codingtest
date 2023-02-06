package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열과 쿼리 17
 * https://www.acmicpc.net/problem/14438
 */
public class BOJ_14438 {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        tree = new int[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, n, 1);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (oper == 1) { // modify
                update(1, n, 1, i, v);
            } else { // min
                int min = getMin(1, n, 1, i, v);
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    private static int update(int start, int end, int node, int index, int value) {
        if (start > index || end < index) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = value;
        }

        int mid = (start + end) / 2;
        return tree[node] = Math.min(update(start, mid, node * 2, index, value), update(mid + 1, end, node * 2 + 1, index, value));
    }

    private static int getMin(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int l = getMin(start, mid, node * 2, left, right);
        int r = getMin(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(l, r);
    }
}
