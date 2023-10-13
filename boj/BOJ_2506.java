package boj;

import java.util.Scanner;

public class BOJ_2506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
