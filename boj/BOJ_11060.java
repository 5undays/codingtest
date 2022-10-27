package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 점프 점프
 * https://www.acmicpc.net/problem/11060
 */
public class BOJ_11060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i <n ;i++) {
            arr[i] = sc.nextInt();
        }
        int[] check = new int[n];
        Arrays.fill(check, - 1);
        Queue<Integer> q =new LinkedList<>();
        q.add(0);
        check[0] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = x + 1; i <= x + arr[x]; i++) {
                if (i >= n) break;
                if (check[i] == -1) {
                    check[i] = check[x] + 1;
                    q.add(i);
                }
            }
        }
        System.out.println(check[n - 1]);
    }
}
