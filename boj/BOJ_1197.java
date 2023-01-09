package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 * https://www.acmicpc.net/problem/1197
 */
public class BOJ_1197 {
    static int[] parent;
    static ArrayList<Point> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점
        int e = Integer.parseInt(st.nextToken()); // 간선
        arr = new ArrayList();
        parent = new int[v + 1];
        int answer = 0;
        int count = 0;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Point(a, b, c));
        }

        Collections.sort(arr);

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (Point p : arr) {
            if (union(p.current, p.next)) {
                answer += p.cost;
                count++;
                if (count == e - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x == y) {
            return false;
        } else {
            parent[x] = y;
            return true;
        }
    }

    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = findParent(parent[x]);
        }
    }

    static class Point implements Comparable<Point> {
        int current;
        int next;
        int cost;

        Point(int current, int next, int cost) {
            this.current = current;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
