package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기
 * https://www.acmicpc.net/problem/2042
 */
public class BOJ_2042 {
    static long[] tree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 수의 변경횟수
        int k = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
        arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[n * 4];
        init(1, n, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) { // b번째 수를 c로 변경
                long diff = c - arr[b];
                arr[b] = c;
                update(1, n, 1, b, diff);
            } else if (a == 2) { // b번째 수부터 c번째 수까지 합을 구하여 출력
                long s = sum(1, n, 1, b, (int) c);
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }

    /**
     * 초기화
     *
     * @param start 시작 인덱스
     * @param end   끝 인덱스
     * @param node  현재 노드
     * @return
     */
    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    /**
     * 원소의 값을 수정
     *
     * @param start 시작 인덱스
     * @param end   끝 인덱스
     * @param node  현재 노드
     * @param index 수정하려고 하는 노드
     * @param diff  수정 값
     */
    static void update(int start, int end, int node, int index, long diff) {
        if (start > index || end < index) return; // 범위 밖
        tree[node] += diff;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    /**
     * 구간의 합
     *
     * @param start 시작 인덱스
     * @param end   끝 인덱스
     * @param node  현재 노드
     * @param left  구간 합 시작 범위
     * @param right 구간 합 끝 범위
     * @return
     */
    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        else {
            int mid = (start + end) / 2;
            return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
        }
    }
}
