package boj;

import java.util.Scanner;

/**
 * 나누기
 * https://www.acmicpc.net/problem/1075
 */
public class BOJ_1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        int k = (n / 100) * 100;
        while (true) {
            if (k % f == 0) {
                int result = k % 100;
                if (result < 10)
                    System.out.println("0" + result);
                else
                    System.out.println(result);
                return;
            }
            k++;
        }
    }
}
