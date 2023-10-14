package boj;

import java.util.Scanner;

public class BOJ_7567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 10;
        for (int i = 1; i < s.length(); i++) {
            int k = s.charAt(i);
            if (s.charAt(i - 1) == k) {
                answer += 5;
            } else {
                answer += 10;
            }
        }
        System.out.println(answer);
    }
}
