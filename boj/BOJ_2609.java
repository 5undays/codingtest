package boj;

import java.util.Scanner;

public class BOJ_2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(gcd(A, B));
        System.out.println(lcm(A, B));
    }

    // 최소 공배수
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대 공약수  
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
