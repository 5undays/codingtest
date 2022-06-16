package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 연결요소
 * https://www.acmicpc.net/problem/11724
 */
public class BOJ_11724 {
    static ArrayList<Integer>[] data;
    static boolean[] check;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        data = new ArrayList[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            data[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            data[v].add(w);
            data[w].add(v);
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x) {
        if (check[x])
            return;
        check[x] = true;
        for (int y : data[x]) {
            if (!check[y]) {
                dfs(y);
            }
        }

    }
}
