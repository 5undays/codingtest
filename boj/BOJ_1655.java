package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */
public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        sb.append(k).append("\n");
        pq.add(k);

        for (int i = 1; i < n; i++) {
            int q = Integer.parseInt(br.readLine());
            if (pq.peek() < q) {
                sb.append(pq.peek());
            } else {
                pq.poll();
                sb.append(q);
                pq.add(q);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
