package boj;

import java.util.Scanner;

public class BOJ_15650 {
    static StringBuffer sb = new StringBuffer();
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, 1, n, m);
        System.out.println(sb.toString());
        go2(1, 0, n, m);
    }

    /**
     * 1 부터 n 까지 중복 없는 오름차순 으로 뽑는다
     * 
     * @param index 현재 인덱스
     * @param start 시작 인덱스
     * @param n     수의 범위
     * @param m     중복 없이 뽑는 갯수
     */
    public static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = start; i <= m; i++) {
            if (!c[i]) {
                c[i] = true;
                a[index] = i;
                go(index + 1, start + 1, n, m);
                c[i] = false;
            }
        }
    }

    /**
     *  1 부터 n 까지 중복 없는 오름차순 으로 뽑는다
     * @param index 현재 인덱스
     * @param selected 지금까지 선택한 수의 갯수
     * @param n 수의 범위
     * @param m 수의 갯수
     */
    public static void go2(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1) {
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        if (index < n) {
            a[selected] = index;
            go2(index + 1, selected + 1, n, m);
            a[selected] = 0;
            go2(index + 1, selected, n, m);
        }
    }
}
