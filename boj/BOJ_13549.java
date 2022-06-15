package boj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/13549
 */
public class BOJ_13549 {
    public static int MAX = 10000000;
    public static int[] dist = new int[MAX]; // 위치에 가기 위해 간 횟수
    public static boolean[] check = new boolean[MAX];
    public static Deque<Integer> d = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        d.add(n); // 현재 위치
        while (!d.isEmpty()) {
            int now = d.remove();
            condition(now + 1, now); // 걷기 (1초)
            condition(now - 1, now); // 걷기 (1초)
            condition2(now * 2, now); // 순간이동 (0초)
        }
        System.out.println(dist[k]);
    }

    private static void condition(int next, int now) {
        if (next >= 0 && next < MAX && !check[next]) {
            d.add(next);
            check[next] = true;
            dist[next] = dist[now] + 1;
        }
    }

    private static void condition2(int next, int now) {
        if (next >= 0 && next < MAX && !check[next]) {
            d.add(next);
            check[next] = true;
            dist[next] = dist[now];
        }
    }
}
