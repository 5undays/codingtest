package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열과 쿼리 16
 * https://www.acmicpc.net/problem/14428
 */
public class BOJ_14428 {
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
        int m = Integer.parseInt(br.readLine() );
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (oper == 1) { // update
                arr[i] = v;
                update(1, n, 1, i);
            } else { // getmin
                int min = getMin(1, n, 1, i, v);
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int minIndex(int x, int y) {
        if (x == 0) { return y; }
        if (y == 0) { return x; }
        if (arr[x] == arr[y]) {
            return Math.min(x, y);
        }
        return arr[x] > arr[y] ? y : x;
    }

    private static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        }
        int mid = (start + end) / 2;
        return tree[node] = minIndex(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    private static int update(int start, int end, int node, int index) {
        if (start > index || end < index) {
            return tree[node];
        }
        if (start == end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return tree[node] = minIndex(update(start, mid, node * 2, index), update(mid + 1, end, node * 2 + 1, index));
    }

    private static int getMin(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return minIndex(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
    }
}
