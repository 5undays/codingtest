package boj;

import java.io.IOException;
import java.util.Scanner;

/**
 * 로또
 * https://www.acmicpc.net/problem/6603
 */
public class BOJ_6603 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0)
                break;
            int[] s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }
            boolean[] check = new boolean[k];
            backtracking(0, 0, s, check);

        }
    }

    /**
     * 
     * @param idx
     * @param depth
     * @param s
     * @param c
     */
    private static void backtracking(int idx, int depth, int[] s, boolean[] c) {
        if (depth == 6) {
            for (int i = 0; i < s.length; i++) {
                if (c[i]) {
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = idx; i < s.length; i++) {
            c[i] = true;
            System.out.println(i + ", "+ depth);
            backtracking(i + 1, depth + 1, s, c);
            c[i] = false;
        }
    }
}
