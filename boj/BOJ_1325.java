package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 효율적인 해킹
 * https://www.acmicpc.net/problem/1325
 */
public class BOJ_1325 {
    static boolean[] visited;
    static LinkedList<Graph> computers;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        computers = new LinkedList<Graph>();
        for (int i = 0; i <= n; i++) {
            computers.add(new Graph(i , null));
        }

        visited = new boolean[n + 1];
        arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //computers.add(a, );
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i);
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(arr[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int x) {
        //for (int computer : computers[x]) {
          //  if (!visited[computer]) {
          //      arr[computer]++;
          //      visited[computer] = true;
          //      dfs(computer);
          //  }
        //}
    }

    static class Graph {
        int value;
        Graph next;

        Graph(int value,Graph next) {
            this.value = value;
            this.next = next;
        }
    }
}
