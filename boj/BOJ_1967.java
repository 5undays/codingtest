package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 지름
 * https://www.acmicpc.net/problem/1967
 */
public class BOJ_1967 {
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;
    static int n;
    static ArrayList<Node>[] tree;
    static int length = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(length, 0);
        System.out.println(answer);
    }

    private static void dfs(int current, int weight) {
        if (answer < weight) {
            answer = weight;
            length = current;
        }
        visited[current] = true;
        for (Node n : tree[current]) {
            if (!visited[n.value]) {
                dfs(n.value, weight + n.weight);
            }
        }
    }

    static class Node {
        int value;
        int weight;

        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
