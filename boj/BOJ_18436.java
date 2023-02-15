package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열과 쿼리 37
 * https://www.acmicpc.net/problem/18436
 */
public class BOJ_18436 {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new int[n * 4];
        init(1, n, 1);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()); // index
            int r = Integer.parseInt(st.nextToken()); // value
            if (oper == 1) { // update
                if (arr[l] % 2 == 0 && r % 2 == 1) { // 홀수로 변경
                    update(1, n, 1, l, r, 1);
                } else if (arr[l] % 2 == 1 && r % 2 == 0) { // 짝수로 변경
                    update(1, n, 1, l, r, 0);
                }
                arr[l] = r;
            } else if (oper == 2) { // 짝수
                sb.append((r - l + 1) - get(1, n, 1, l, r)).append("\n");
            } else { // 홀수
                sb.append(get(1, n, 1, l, r)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start] % 2 == 0 ? 0 : 1;
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2)
                + init(mid + 1, end, node * 2 + 1);
    }

    private static void update(int start, int end, int node, int index, int value, int isEven) {
        if (start > index || end < index) {
            return;
        }
        if (value % 2 == 0) {
            tree[node]--;
        } else {
            tree[node]++;
        }
        if (start == end) {
            tree[node] = isEven;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, value, isEven);
        update(mid + 1, end, node * 2 + 1, index, value, isEven);
    }

    private static int get(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return get(start, mid, node * 2, left, right)
                + get(mid + 1, end, node * 2 + 1, left, right);
    }
}
