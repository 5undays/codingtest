package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15666 {
    static int[] data = new int[10];
    static int[] temp = new int[10];
    static int[] a = new int[10];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || data[i] != data[i - 1]) {
                continue;
            }
            temp[k++] = data[i];
        }
        System.out.println(go(0, n, m));
    }

    private static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(temp[a[i]]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder sb1 = new StringBuilder();
        if (index < n) {
            for (int i = 0; i < n; i++) {
                a[index] = i;
                sb1.append(go(index + 1, n, m));
            }
        }
        return sb1;
    }
}
