package boj;

import java.util.Scanner;

/**
 * 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085
 */
public class BOJ_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int answer = Math.min(x, y);
        int answer2 = Math.min(w - x, h - y);
        System.out.println(Math.min(answer, answer2));
    }
}   
