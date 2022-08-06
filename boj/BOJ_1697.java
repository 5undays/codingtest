package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */
public class BOJ_1697 {

    static final int MAX = 1000000;
    static final boolean[] check = new boolean[MAX]; // 방문 여부
    static final int[] dist = new int[MAX]; // 인덱스당 접근 시간
    static final Queue<Integer> queue = new LinkedList<>(); // 현재 위치

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 형이 있는 위치
        int k = sc.nextInt(); // 동생이 있는 위치

        // 시작점을 수동으로 넣어준다
        queue.add(n);
        check[n] = true;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            // 접근 할 수 있는 모든 경우의 수에 해당하는 곳에 접근한다
            condition(now - 1, now);
            condition(now + 1, now);
            condition(now * 2, now);
        }
        System.out.println(dist[k]);
    }

    private static void condition(int n, int now) {
        if (n < MAX && n >= 0 && !check[n]) {
            queue.add(n);
            check[n] = true;
            dist[n] = dist[now] + 1;
        }
    }
}
