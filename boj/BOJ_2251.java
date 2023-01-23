package boj;

import java.util.*;

/**
 * 물통
 * https://www.acmicpc.net/problem/2251
 */
public class BOJ_2251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        boolean[][][] visited = new boolean[201][201][201];

        ArrayList<Integer> answer = new ArrayList<>();

        Queue<Water> q = new LinkedList<>();
        q.add(new Water(0, 0, c));

        while (!q.isEmpty()) {
            Water w = q.poll();

            if (visited[w.a][w.b][w.c]) {
                continue;
            }
            visited[w.a][w.b][w.c] = true;
            if (w.a == 0) {
                answer.add(w.c);
            }

            // a => b
            if (w.a + w.b > b) {
                q.add(new Water(w.a + w.b - b, b, w.c));
            } else {
                q.add(new Water(0, w.a + w.b, w.c));
            }

            // a => c
            if (w.a + w.c > c) {
                q.add(new Water(w.a + w.c - c, w.b, c));
            } else {
                q.add(new Water(0, w.b, w.a + w.c));
            }

            // b => a
            if (w.a + w.b > a) {
                q.add(new Water(a, w.a + w.b - a, w.c));
            } else {
                q.add(new Water(w.a + w.b, 0, w.c));
            }

            // b => c
            if (w.b + w.c > c) {
                q.add(new Water(w.a, w.b + w.c - c, c));
            } else {
                q.add(new Water(w.a, 0, w.b + w.c));
            }

            // c => a
            if (w.a + w.c > a) {
                q.add(new Water(a, w.b, w.c + w.a - a));
            } else {
                q.add(new Water(w.a + w.c, w.b, 0));
            }

            // c => b
            if (w.b + w.c > b) {
                q.add(new Water(w.a, b, w.c + w.b - b));
            } else {
                q.add(new Water(w.a, w.b + w.c, 0));
            }

        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    static class Water {
        int a;
        int b;
        int c;

        Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
