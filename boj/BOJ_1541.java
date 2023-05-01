package boj;

import java.util.Scanner;

/**
 * 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */
public class BOJ_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("-");
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < s.length; i++) {
            int result = 0;
            String[] plus = s[i].split("\\+");
            for (int j = 0; j < plus.length; j++) {
                result += Integer.parseInt(plus[j]);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = result;
            } else {
                answer -= result;
            }
        }

        System.out.println(answer);
    }
}
