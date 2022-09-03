package boj;

import java.util.Scanner;

/**
 * 나머지
 * https://www.acmicpc.net/problem/3052
 */
public class BOJ_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[1000];
        for (int i = 0; i < 10; i++) {
            arr[sc.nextInt() % 42] = true;
        }
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
