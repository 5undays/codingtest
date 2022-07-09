package boj;

import java.util.Scanner;

/**
 * N과 M (1)
 * https://www.acmicpc.net/problem/15649
 */
public class BOJ_15649 {
    public static boolean[] c = new boolean[10];
    public static StringBuffer sb = new StringBuffer();
    public static int[] a = new int[10]; //

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
        System.out.println(sb.toString());
    }

    /**
     * 1 부터 n 까지 중복없는 m 개의 수를 뽑는다
     * 
     * @param index 현재 인덱스
     * @param n     수의 범위
     * @param m     중복 없이 뽑는 갯수
     */
    public static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1) // 마지막 수가 아니면
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!c[i]) {
                c[i] = true;
                a[index] = i;
                go(index + 1, n, m);
                c[i] = false;
            }
        }
    }
}
