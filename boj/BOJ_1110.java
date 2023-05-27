package boj;

import java.util.Scanner;

/**
 * 더하기 사이클
 * https://www.acmicpc.net/problem/1110
 */
public class BOJ_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        String k = String.valueOf(n);
        while (true) {
            int sum = 0;
            for (int i = 0; i < k.length(); i++) {
                sum += Integer.parseInt(k.charAt(i) + "");
            }
            answer++;
            k = String.valueOf(Integer.parseInt(String.valueOf(k.charAt(k.length() - 1))
                    + String.valueOf(sum).charAt(String.valueOf(sum).length() - 1)));
            if (k.equals(String.valueOf(n))) {
                break;
            }
        }
        System.out.println(answer);
    }
}
