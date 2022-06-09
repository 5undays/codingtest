package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
    static StringBuffer sb = new StringBuffer();
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];
    static int[] data = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        // go(0, 0, n, m);
        Arrays.sort(data);
        go2(0, 0, n, m);
        System.out.println(sb.toString());
    }

    static StringBuilder go3(int index, int selected, int n, int m) {
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(data[a[i]]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index >= n)
            return ans;
        a[selected] = index;
        ans.append(go3(index + 1, selected + 1, n, m));
        a[selected] = 0;
        ans.append(go3(index + 1, selected, n, m));
        return ans;
    }

    // public static void go2(int selected, int index, int n, int m) {
    // if (selected == m) {
    // for (int i = 0; i < m; i++) {
    // sb.append(data[a[i]]);
    // if (i != m - 1) {
    // sb.append(" ");
    // }
    // }
    // sb.append("\n");
    // }

    // if (index < n) {
    // System.out.println(selected);
    // a[selected] = index;
    // go2(selected + 1, index + 1, n, m);
    // a[selected] = 0;
    // go2(selected, index + 1, n, m);
    // }
    // }

    public static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(data[a[i]]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = start; i < n; i++) {
            if (!c[i]) {
                c[i] = true;
                a[index] = i;
                go(index + 1, start + 1, n, m);
                c[i] = false;
            }
        }
    }
}
