package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 요세푸스 순열0
 * https://www.acmicpc.net/problem/11866
 */
public class BOJ_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int i = 1;
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        while (!q.isEmpty()) {
            int x = q.poll();
            if (i == k) {
                sj.add(x + "");
                i = 1;
            } else {
                q.add(x);
                i++;
            }
        }
        System.out.println(sj);
    }
}
