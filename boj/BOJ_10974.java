package boj;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 모든 순열
 * https://www.acmicpc.net/problem/10974
 */
public class BOJ_10974 {
    static int n;
    static Set<String> set = new LinkedHashSet<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        dfs(0, "");
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, String s) {
        if (depth == n) {
            set.add(s);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, s + i + " ");
                visited[i] = false;
            }
        }
    }
}
