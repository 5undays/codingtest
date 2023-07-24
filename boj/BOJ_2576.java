package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 홀수
 * https://www.acmicpc.net/problem/2576
 */
public class BOJ_2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int k = sc.nextInt();
            if (k % 2 != 0) {
                arr.add(k);
                min = Math.min(min, k);
                sum += k;
            }
        }

        if (arr.size() > 0) {
            System.out.println(sum + "\n" + min);
        } else {
            System.out.println(-1);
        }
    }
}
