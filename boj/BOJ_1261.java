package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1261 {
    static int MAX = 1000000;
    static boolean[][] check = new boolean[MAX][MAX];
    static Queue<Integer> q = new LinkedList<>();
    static int[][] dist = new int[MAX][MAX];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] data = new int[n][m]; 

        for (int i = m; i < m ;i++) {
            for (int j = n; j < n; i++) {
                data[i][j] = sc.nextInt();
            }
        }

        q.add(1); 
        q.add(1);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            condition(x + 1, y, x, y);
            condition(x, y + 1, x, y);
            condition(x - 1, y, x, y);
            condition(x, y - 1, x, y);            
        }
    }
    
    private static void condition(int x, int y, int prev_x, int prev_y) {
        if (x >= 0 && x < MAX && y > 0 && y < MAX && !check[x][y]) {
            q.add(x);
            q.add(y);
            check[x][y] = true;
            dist[x][y] = dist[prev_x][prev_y] + 1;
        }
    }
}
