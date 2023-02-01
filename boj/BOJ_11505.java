package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 곱 구하기
 * https://www.acmicpc.net/problem/11505
 */
public class BOJ_11505 {
    static int[] arr;
    static long[] tree;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간의 곱
        arr = new int[n + 1];
        tree = new long[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, n, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                arr[b] = c;
                update(1, n, 1, b, c);
            } else {
                sb.append(multiply(1, n, 1, b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
    }

    private static long update(int start, int end, int node, int index, int value) {
        if (start > index || end < index) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = value;
        }
        int mid = start + (end - start) / 2;
        update(start, mid, node * 2, index, value);
        update(mid + 1, end, node * 2 + 1, index, value);
        return tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
    }

    private static long multiply(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return 1;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        long l = multiply(start, mid, node * 2, left, right);
        long r = multiply(mid + 1, end, node * 2 + 1, left, right);
        return l * r % MOD;
    }
}
