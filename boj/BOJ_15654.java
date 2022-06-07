package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        go(0, n, m);
        System.out.println(sb.toString());
    }

    static StringBuffer sb = new StringBuffer();

    public static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[a[i]]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            if (!c[i]) { // 중복 불가
                c[i] = true;
                a[index] = i;
                go(index + 1, n, m);
                c[i] = false;
            }
        }
    }
}
