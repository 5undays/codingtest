package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최소 힙
 * https://www.acmicpc.net/problem/1927
 */
public class BOJ_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x > 0) {
                pq.add(x);
            } else if (x == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
