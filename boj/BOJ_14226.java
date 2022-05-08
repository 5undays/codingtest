package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 이모티콘
// https://www.acmicpc.net/problem/14226
public class BOJ_14226 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] d = new int[n+1][n+1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(d[i], -1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);

        d[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();

            if (d[s][s] == -1) {

            } 

            if (s+c <= n && d[s+c][c] == -1) {

            }

            if (s-1 >= 0 && d[s-1][c] == -1) {
                
            }
        }

        int ans = -1;
        for (int i = 0 ; i <= n; i++ ) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }

        System.out.println(ans);
    }
}
