package boj;

import java.util.Scanner;

/**
 * 삼각형 외우기
 * https://www.acmicpc.net/problem/10101
 */
public class BOJ_10101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int hap = a + b + c;
        if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else if (hap == 180 && (a == b || b == c || a == c)) {
            System.out.println("Isosceles");
        } else if (hap == 180) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
