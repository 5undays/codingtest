package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가계부 (Hard)
 * https://www.acmicpc.net/problem/12837
 */
public class BOJ_12837 {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //월곡이가 살아온 날
        int q = Integer.parseInt(st.nextToken()); //쿼리의 개수
        tree = new long[n * 4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (oper == 1) { // update
                update(1, n, 1, p, x);
            } else { // sum
                long sum = sum(1, n, 1, p, x);
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(int start, int end, int node, long index, long value) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] += value;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, value);
        update(mid + 1, end, node * 2 + 1, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long sum(int start, int end, int node, long left, long right) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
