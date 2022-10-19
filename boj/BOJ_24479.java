package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 알고리즘 수업 - 깊이 우선 탐색 1
 * https://www.acmicpc.net/problem/24479
 */
public class BOJ_24479 {
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    static int[] answer;
    static int n;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작점
        arr = new ArrayList[n + 1];
        check = new boolean[n + 1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i < n; i++) {
            Collections.sort(arr[i]);
        }

        check[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(answer[i]).append('\n');
        System.out.print(sb);
    }

    public static void dfs(int current) {
        answer[current] = ++index;
        for (int next : arr[current]) {
            if (!check[next]) {
                check[next] = true;
                dfs(next);
            }
        }
    }

}
