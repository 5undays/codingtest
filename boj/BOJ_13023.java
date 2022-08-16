package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ABCDE
 * https://www.acmicpc.net/problem/13023
 */
public class BOJ_13023 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람 수
        int m = sc.nextInt(); // 관계 개수
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(w);
            arr[w].add(u);
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 1);
        }
        System.out.println(0);
    }

    static void dfs(int index, int depth) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }

        visited[index] = true;
        for (int x : arr[index]) {
            if (!visited[x]) {
                dfs(x, depth + 1);
            }
        }

        visited[index] = false;
    }
}
