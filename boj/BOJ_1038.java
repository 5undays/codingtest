package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 감소하는 수
 * https://www.acmicpc.net/problem/1038
 */
public class BOJ_1038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 10) {
            System.out.println(n);
        } else if (n > 1022) {
            System.out.println(-1);
        } else {
            ArrayList<Long> arr = new ArrayList<>();
            for (int i = 1; i <= 1023; i++) {
                long num = 0;
                int temp = i;
                for (int j = 9; j >= 0; j--) {
                    if (temp % 2 == 1) {
                        num = 10 * num + j;
                    }
                    temp /= 2;
                }
                arr.add(num);
            }
            Collections.sort(arr);
            System.out.println(arr.get(n));
        }
    }
}
