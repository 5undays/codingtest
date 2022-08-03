package boj;

import java.util.Scanner;

/**
 * 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */
public class BOJ_1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        while (n-- > 0) {
            if (isPrime(sc.nextInt())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    /**
     * 소수 검증
     * @param number 숫자
     * @return 소수 여부
     */
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
