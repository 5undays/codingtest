package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 도시 분할 계획
 * https://www.acmicpc.net/problem/1647
 */
public class BOJ_1647 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<House> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new House(a, b, c));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;
        Collections.sort(arr);

        for (House house : arr) {
            if (union(house.current, house.next)) {
                if (count == n - 2) {
                    break;
                }
                answer += house.cost;
                count++;
            }
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[y] = x;
            return true;
        } else {
            return false;
        }
    }

    static class House implements Comparable<House> {
        int current;
        int next;
        int cost;

        House(int current, int next, int cost) {
            this.current = current;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(House o) {
            return this.cost - o.cost;
        }

    }
}
