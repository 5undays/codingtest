package boj;

import java.util.Scanner;

/**
 * 저작권
 * https://www.acmicpc.net/problem/2914
 */
public class BOJ_2914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 앨범에 수록된 곡의 개수
        int l = sc.nextInt(); // 평균값
        System.out.println(a * (l - 1) + 1);
    }
}
