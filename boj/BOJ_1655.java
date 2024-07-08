package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */
public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if (max.isEmpty()) {
                max.add(k);
            } else {
                if (max.size() > min.size()) {
                    min.add(k);
                } else {
                    max.add(k);
                }

                int maxTop = max.peek();
                int minTop = min.peek();

                if (maxTop > minTop) {
                    max.poll(); min.poll();
                    max.add(minTop);
                    min.add(maxTop);
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
