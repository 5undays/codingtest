package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가로수
 * https://www.acmicpc.net/problem/2485
 */
public class BOJ_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num - a;
            a = num;
        }

        int g = arr[0];
        for (int i = 1; i < n; i++) {
            g = gcd(g, arr[i]);
        }

        int answer = 0;
        for (int i = 0; i < n - 1;i++) {
            answer += arr[i] / g - 1;
        }

        System.out.println(answer);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
