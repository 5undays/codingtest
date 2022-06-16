package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    static ArrayList<Integer>[] data; // 정점
    static int n = 0;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 번호
        data = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            data[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int w = sc.nextInt();
            int u = sc.nextInt();
            data[u].add(w);
            data[w].add(u);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(data[i]);
        }

        check = new boolean[n + 1];
        System.out.print("dfs : ");
        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        System.out.print("bfs : ");
        bfs(v);
    }

    // depth find Search
    private static void dfs(int start) {
        if (check[start])
            return;
        check[start] = true;
        System.out.print(start + " ");
        for (int x : data[start]) {
            if (!check[x]) {
                dfs(x);
            }
        }
    }

    // breadth find search
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int q = queue.remove();
            System.out.print(q + " ");
            for (int x : data[q]) {
                if (!check[x]) {
                    check[x] = true;
                    queue.add(x);
                }
            }
        }
    }
}
