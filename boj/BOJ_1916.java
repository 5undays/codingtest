package boj;

import java.util.*;

/**
 * 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */
public class BOJ_1916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<City>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            arr[start].add(new City(end, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] visit = new boolean[n + 1];
        PriorityQueue<City> q = new PriorityQueue<>();
        q.add(new City(start, 0));
        costs[start] = 0;
        while (!q.isEmpty()) {
            City city = q.poll();
            if (!visit[city.next]) {
                visit[city.next] = true;
                for (City c : arr[city.next]) {
                    if (!visit[c.next] && costs[city.next] + c.cost < costs[c.next]) {
                        costs[c.next] = costs[city.next] + c.cost;
                        q.add(new City(c.next, costs[c.next]));
                    }
                }
            }
        }
        System.out.println(costs[end]);
    }

    static class City implements Comparable<City> {
        int next;
        int cost;

        City(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }
}
