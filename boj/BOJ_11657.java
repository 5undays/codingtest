package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 타임머신
 * https://www.acmicpc.net/problem/11657
 */
public class BOJ_11657 {
    static ArrayList<City> arr = new ArrayList<>();
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작
            int b = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 시간
            arr.add(new City(a, b, c));
        }
        distance = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (City city : arr) {
                if (distance[city.start] == Integer.MAX_VALUE) continue;
                if (distance[city.next] > distance[city.start] + city.time) {
                    distance[city.next] = distance[city.start] + city.time;
                }
            }
        }

        for (City city : arr) {
            if (distance[city.start] == Integer.MAX_VALUE) continue;
            if (distance[city.next] > distance[city.start] + city.time) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class City {
        int start;
        int next;
        int time;

        City(int start, int next, int time) {
            this.start = start;
            this.next = next;
            this.time = time;
        }
    }
}
