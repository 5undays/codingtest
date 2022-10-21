package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 촌수계산
 * https://www.acmicpc.net/problem/2644
 */
public class BOJ_2644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 전체 사람의 수
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            arr[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(w);
            arr[w].add(u);
        }

        int t = Math.min(a,b);
        int w = Math.max(a,b);
        int[] depth = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == w) {
                break;
            }
            for (int i = 0; i < arr[x].size(); i++) {
                int s = arr[x].get(i);
                if (depth[s] == 0) {
                    q.add(s);
                    depth[s] = depth[x] + 1;
                }
            }
        }

        if (depth[w] > 0) {
            System.out.println(depth[w]);
        } else {
            System.out.println(-1);
        }
    }
}
