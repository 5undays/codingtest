package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 네트워크 연결
 * https://www.acmicpc.net/problem/1922
 */
public class BOJ_1922 {
    static ArrayList<Network> arr = new ArrayList<>();
    static int[] parent;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Network(a, b, c));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Collections.sort(arr);

        int answer = 0;
        for (Network network : arr) {
            if (find(network.current) != find(network.next)) {
                answer += network.cost;
                union(network.current, network.next);
            }
        }
        System.out.println(answer);
    }

    /**
     * 부모 노드 찾기
     * @param x
     * @return
     */
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    /**
     * 부모 노드를 병합
     * @param a
     * @param b
     */
    static void union(int a, int b) {
        x = find(a);
        y = find(b);
        if (x != y) {
            parent[y] = x;
        }
    }

    static class Network implements Comparable<Network> {
        int current;
        int next;
        int cost;

        Network(int current, int next, int cost) {
            this.current = current;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Network o) {
            return this.cost - o.cost;
        }
    }
}
