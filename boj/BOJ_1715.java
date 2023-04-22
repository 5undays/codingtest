package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 */
public class BOJ_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int answer = 0;
        while (pq.size() > 1) {
            int prev = pq.poll();
            int current = pq.poll();
            answer += prev + current;
            pq.add(prev + current);
        }
        System.out.println(answer);
    }
}
