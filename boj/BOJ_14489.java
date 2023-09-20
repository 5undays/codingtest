package boj;

import java.util.Scanner;

public class BOJ_14489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a + b >= c * 2) {
            System.out.println(a + b - (2 * c));
        } else {
            System.out.println(a + b);
        }
    }
}
