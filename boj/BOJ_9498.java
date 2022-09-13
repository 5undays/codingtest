package boj;

import java.util.Scanner;

/**
 * 시험성적
 * https://www.acmicpc.net/problem/9498
 */
public class BOJ_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.close();
        if (test >= 90 && test <= 100) {
            System.out.println("A");
        } else if (test >= 80 && test <= 89) {
            System.out.println("B");
        } else if (test >= 70 && test <= 79) {
            System.out.println("C");
        } else if (test >= 60 && test <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
