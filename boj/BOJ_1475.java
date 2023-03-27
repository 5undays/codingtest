package boj;

import java.util.Scanner;

/**
 * 방 번호
 * https://www.acmicpc.net/problem/1475
 */
public class BOJ_1475 {
    static int[] data = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int x = n % 10;
            if (x == 9) {
                x = 6;
            }
            data[x]++;
            n = n / 10;
        }

        data[6] = (data[6] + 1) / 2;

        int answer = 0;
        for (int x : data) {
            answer = Math.max(x, answer);
        }
        System.out.println(answer);
    }
}
