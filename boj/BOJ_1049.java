package boj;

import java.util.Scanner;

/**
 * 기타줄
 * https://www.acmicpc.net/problem/1049
 */
public class BOJ_1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n개의 기타줄
        int m = sc.nextInt();
        int pack = Integer.MAX_VALUE;
        int wing = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            pack = Math.min(pack, sc.nextInt());
            wing = Math.min(wing, sc.nextInt());
        }

        int k = n / 6;
        int l = n % 6;

        if (l * wing >= pack) {
            System.out.println(pack * k + pack);
        } else if (wing * 6 < pack) {
            System.out.println(n * wing);
        } else {
            System.out.println(k * pack + l * wing);
        }
    }
}
