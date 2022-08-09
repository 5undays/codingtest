package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class BOJ_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 컴퓨터의 개수
        int m = sc.nextInt(); // 컴퓨터 쌍의 개수
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0 ; i < m; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(w);
            list[w].add(u);
        }

        int answer = 0;
        q.offer(1);
        while (!q.isEmpty()) {
            int comp = q.poll();
            if (!visited[comp]) {
                answer++;
                visited[comp] = true;
                for (int i = 0 ; i < list[comp].size(); i ++) {
                    q.offer(list[comp].get(i));
                }
            }
        }

        System.out.println(answer - 1);
    }
}
