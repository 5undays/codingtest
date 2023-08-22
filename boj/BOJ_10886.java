package boj;

import java.util.Scanner;

/**
 * 0 = not cute / 1 = cute
 * https://www.acmicpc.net/problem/10886
 */
public class BOJ_10886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            if (m == 1) {
                k++;
            }
        }

        System.out.println(n - k > k ? "Junhee is not cute!" : "Junhee is cute!");
    }
}
