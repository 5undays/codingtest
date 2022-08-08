package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 알고 스팟
 * https://www.acmicpc.net/problem/1261
 */
public class BOJ_1261 {
    static int m;
    static int n;
    static int[][] map;
    static int answer = 9999;
    static boolean[][] check;
    static PriorityQueue<Room> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        q.add(new Room(0, 0, 0));
        check[0][0] = true;
        while (!q.isEmpty()) {
            Room r = q.remove();
            int x = r.x;
            int y = r.y;

            if (x == n - 1 && y == m - 1) {
                answer = Math.min(answer, r.count);
            }

            condition(x + 1, y, r.count);
            condition(x, y + 1, r.count);
            condition(x - 1, y, r.count);
            condition(x, y - 1, r.count);
        }

        System.out.println(answer);
    }

    /**
     * 조건
     * 
     * @param x  x 위치
     * @param y  y 위치
     * @param cnt 
     */
    private static void condition(int x, int y, int cnt) {
        if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y]) {
            check[x][y] = true;
            if (map[x][y] == 1) {
                q.add(new Room(x, y, cnt + 1));
            } else {
                q.add(new Room(x, y, cnt));
            }
        }
    }

    static class Room implements Comparable<Room> {
        int x;
        int y;
        int count;

        Room(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Room o) {
            // TODO Auto-generated method stub
            return this.count - o.count;
        }
    }
}
