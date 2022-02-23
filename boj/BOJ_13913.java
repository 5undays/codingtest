package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.locks.Condition;

// https://www.acmicpc.net/problem/13913
public class BOJ_13913 {

    static final int MAX = 1000000;
    static final boolean[] check = new boolean[MAX]; // 방문 여부

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>(); // 방문 큐
        int[] dist = new int[MAX];
        int[] prevDist = new int[MAX];
        queue.add(n);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (condition(now - 1)) {
                queue.add(now - 1);
                check[now - 1] = true;
                dist[now - 1] = dist[now] + 1;
                prevDist[now - 1] = now;
            }
            if (condition(now + 1)) {
                queue.add(now + 1);
                check[now + 1] = true;
                dist[now + 1] = dist[now] + 1;
                prevDist[now + 1] = now;
            }
            if (condition(now * 2)) {
                queue.add(now * 2);
                check[now * 2] = true;
                dist[now * 2] = dist[now] + 1;
                prevDist[now * 2] = now;
            }
        }

        System.out.println(dist[k]);
        Stack<Integer> result = new Stack<>();
        result.push(k);
        int idx = k;
        while (idx != n) {
            result.push(prevDist[idx]);
            idx = prevDist[idx];
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }

    private static boolean condition(int num) {
        if (num >= 0 && num < MAX && !check[num]) {
            return true;
        }
        return false;
    }
}
