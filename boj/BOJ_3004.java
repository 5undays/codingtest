package boj;

import java.util.Scanner;

public class BOJ_3004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                answer += 2;
            } else {
                answer += ((i / 2) + 1);
            }
        }
        System.out.println(answer);
    }
}
