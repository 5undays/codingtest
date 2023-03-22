package boj;

import java.util.Scanner;

/**
 * 분수찾기
 * https://www.acmicpc.net/problem/1193
 */
public class BOJ_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int end = 0;
        int line = 0;
        while (end < x) {
            end += ++line;
        }

        int diff = end - x;
        System.out.println(line + ", " + end);
        if (line % 2 == 0) {
            System.out.println((line - diff) + "/" + (diff + 1));
        } else {
            System.out.println((diff + 1) + "/" + (line - diff));
        }
    }
}
