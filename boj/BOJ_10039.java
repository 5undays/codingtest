package boj;

import java.util.Scanner;

/**
 * 평균 점수
 * https://www.acmicpc.net/problem/10039
 */
public class BOJ_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int k = sc.nextInt();
            if (k > 40) {
                sum += k;
            } else {
                sum += 40;
            }
        }

        System.out.println(sum / 5);
    }
}
