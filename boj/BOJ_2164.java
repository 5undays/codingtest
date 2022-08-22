package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 카드 2
 * https://www.acmicpc.net/problem/2164
 */
public class BOJ_2164 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.remove();
            q.offer(q.remove());
        }

        System.out.println(q.poll());
    }
}
