package boj;

import java.util.Scanner;

/**
 * 정육각형과 삼각형
 * https://www.acmicpc.net/problem/14264
 */
public class BOJ_14264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        System.out.println(Math.sqrt(3) / 4 * l * l);
    }
}
