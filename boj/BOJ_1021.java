package boj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 회전하는 큐
 * https://www.acmicpc.net/problem/1021
 */
public class BOJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 큐의 크기
        int m = sc.nextInt(); // 뽑아내려고 하는 수

        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            d.offer(i);
        }

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int k = arr[i];

            while (k != d.getFirst()) {
                if (d.indexOf(k) <= d.size() / 2) {
                    int front = d.pollFirst();
                    d.addLast(front);
                } else {
                    int tail = d.pollLast();
                    d.addFirst(tail);
                }
                answer++;
            }

            if (k == d.getFirst()) {
                d.pollFirst();
            }
        }
        System.out.println(answer);
    }
}
