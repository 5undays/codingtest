package boj;

import java.util.Scanner;

/**
 * 숫자의 합
 * https://www.acmicpc.net/problem/11720
 */
public class BOJ_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Integer.parseInt(s.charAt(i)+"");
        }
        System.out.println(answer);
    }
}
