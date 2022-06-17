package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 이분그래프
 * https://www.acmicpc.net/problem/1707
 */
public class BOJ_1707 {
    static ArrayList<Integer>[] list;
    static int[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 테스트 케이스 개수
        while (k-- > 0) {
            int v = sc.nextInt(); // 그래프 정점의 개수
            int e = sc.nextInt(); // 간선의 개수
            list = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                list[i] = new ArrayList<Integer>();
            }
            for (int i = 1; i <= e; i++) {
                int u = sc.nextInt();
                int w = sc.nextInt();
                list[u].add(w);
                list[w].add(u);
            }
            color = new int[v + 1];
            boolean answer = true;

            for (int i = 1; i <= v; i++) {
                dfs(i, 1);
            }

            for (int i = 1; i <= v; i++) {
                for (int j : list[i]) {
                    if (color[i] == color[j]) {
                        answer = false;
                    }
                }
            }

            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static void dfs(int index, int c) {
        if (color[index] != 0) {
            return;
        }
        color[index] = c;
        for (int x : list[index]) {
            dfs(x, 3 - c);
        }
    }
}
