package boj;

import java.util.Scanner;

/**
 * 최대공약수 하나 빼기
 * https://www.acmicpc.net/problem/14476
 */
public class BOJ_14476 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] leftGCD = new int[n + 1];
        int[] rightGCD = new int[n + 1];

        leftGCD[1] = arr[1];
        rightGCD[n] = arr[n];

        for (int i = 2; i <= n; i++) {
            leftGCD[i] = gcd(leftGCD[i - 1], arr[i]);
        }

        for (int i = n - 1; i >= 1; i--) {
            rightGCD[i] = gcd(rightGCD[i + 1], arr[i]);
        }

        int answer = 0;
        int gcd = 0;

        for (int i = 1; i < n; i++) {
            int currentGcd = gcd(leftGCD[i - 1], rightGCD[i + 1]);
            if (arr[i] % currentGcd != 0 && gcd < currentGcd) {
                answer = arr[i];
                gcd = currentGcd;
            }
        }

        if (answer == 0 && gcd == 0) {
            System.out.println(-1);
        } else {
            System.out.println(gcd + " " + answer);
        }
    }
}
