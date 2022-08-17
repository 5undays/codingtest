package boj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/13549
 */
public class BOJ_13549 {
    public static int MAX = 1000000;
    public static int[] dist = new int[MAX]; // 인덱스 위치에 가기 위해 간 횟수
    public static boolean[] check = new boolean[MAX]; // 방문 여부
    public static Deque<Integer> d = new LinkedList<>(); // 현재 위치 담는

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        d.add(n); // 현재 위치
        dist[n] = 0; // 현재 거리
        check[n] = true; // 현재 위치 방문
        while (!d.isEmpty()) {
            int now = d.remove();
            condition2(now * 2, now); // 순간이동 (0초)
            condition(now - 1, now); // 걷기 (1초)
            condition(now + 1, now); // 걷기 (1초)
        }
        System.out.println(dist[k]);
    }

    private static void condition(int next, int current) {
        if (next < MAX && next >= 0) {
            if (!check[next]) {
                check[next] = true;
                dist[next] = dist[current] + 1;
                d.addLast(next);
            }
        }
    }

    private static void condition2(int next, int current) {
        if (next < MAX && next >= 0) {
            if (!check[next]) {
                check[next] = true;
                dist[next] = dist[current];
                d.addFirst(next);
            }
        }
    }
}
