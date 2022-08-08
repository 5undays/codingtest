package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질 4
 * https://www.acmicpc.net/problem/13913
 */
public class BOJ_13913 {

    static final int MAX = 1000000;
    static final boolean[] check = new boolean[MAX]; // 방문 여부
    static Queue<Integer> queue = new LinkedList<>(); // 방문 큐
    static int[] dist = new int[MAX]; // 몇번만에 방문 했는지
    static int[] prevDist = new int[MAX]; // 이전에 방문한 곳

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 형이 있는 위치
        int k = sc.nextInt(); // 동생이 있는 위치

        queue.add(n);
        check[n] = true;
        dist[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            condition(now - 1, now); // 걷기 (1초)
            condition(now + 1, now); // 걷기 (1초)
            condition(now * 2, now); // 순간이동
        }

        System.out.println(dist[k]); // 동생을 찾는 가장 빠른 시간

        print(n, k);
    }

    /**
     * 결과 출력
     * 
     * @param n 형 위치
     * @param k 동생 위치
     */
    private static void print(int n, int k) {
        if (n != k) {
            print(n, prevDist[k]);
        }
        System.out.print(k + " ");
    }

    /**
     * 조건
     * 
     * @param num 다음 위치
     * @param now 지금 위치
     * @return
     */
    private static void condition(int num, int now) {
        if (num >= 0 && num < MAX && !check[num]) {
            queue.add(num);
            check[num] = true;
            dist[num] = dist[now] + 1;
            prevDist[num] = now;
        }
    }
}
