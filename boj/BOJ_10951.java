package boj;

import java.util.Scanner;

/**
 * A+B - 4
 * https://www.acmicpc.net/problem/10951
 */
public class BOJ_10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
        sc.close();
    }
}
