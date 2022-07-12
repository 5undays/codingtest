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
     * idx 부터 중복 없는 오름차순으로 뽑는다
     * @param idx 현재 인덱스
     * @param depth 중복 없이 뽑는 갯수
     * @param s 전체 배열
     * @param c 중복 없는 배열 방문 여부
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
            backtracking(i + 1, depth + 1, s, c);
            c[i] = false;
        }
    }
}
