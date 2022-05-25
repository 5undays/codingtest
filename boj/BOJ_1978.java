package boj;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1978
public class BOJ_1978 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        while (n-- > 0) {
            if (is_prime(n)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean is_prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n/2; i++) {
            if (n % i != 0) {
                return false;
            } 
        }
        return true;
    }
}
