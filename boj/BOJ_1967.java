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
    static int answer = 0;
    static boolean[] visited;
    static int n;
    static ArrayList<Node> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node node = new Node(parent, child, weight);
            arr.add(node);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n + 1];
            dfs(arr.get(i).parent, 0,0);
        }

        System.out.println(answer);
    }

    private static void dfs(int current, int depth, int weight) {
        if (visited[current]) {
            return;
        }

        if (depth == n) {
            answer = Math.max(answer, weight);
            return;
        }

        visited[current] = true;
        //dfs(arr., depth + 1, weight + arr.);
    }

    static class Node {
        int parent;
        int child;
        int weight;

        Node(int parent, int child, int weight) {
            this.parent = parent;
            this.child = child;
            this.weight = weight;
        }
    }
}
