package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 숨바꼭질 4
 * https://www.acmicpc.net/problem/13913
 */
public class BOJ_13913 {

    static final int MAX = 1000000;
    static final boolean[] check = new boolean[MAX]; // 방문 여부
    static Queue<Integer> queue = new LinkedList<>(); // 방문 큐
    static int[] dist = new int[MAX];
    static int[] prevDist = new int[MAX];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 형이 있는 위치
        int k = sc.nextInt(); // 동생이 있는 위치

        queue.add(n);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            condition(now - 1, now);
            condition(now + 1, now);
            condition(now * 2, now);
        }

        System.out.println(dist[k]); // 동생을 찾는 가장 빠른 시간
        Stack<Integer> result = new Stack<>();
        result.push(k);
        int idx = k;
        while (idx != n) {
            result.push(prevDist[idx]);
            idx = prevDist[idx];
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " "); // 가장 빨리 찾는 이동 방법
        }
    }

    private static boolean condition(int num, int now) {
        if (num >= 0 && num < MAX && !check[num]) {
            queue.add(num);
            check[num] = true;
            dist[num] = dist[now] + 1;
            prevDist[num] = now;
        }
        return false;
    }
}
