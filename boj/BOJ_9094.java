package boj;

import java.util.Scanner;

/**
 * 수학적 호기심
 * https://www.acmicpc.net/problem/9094
 */
public class BOJ_9094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (((i * i) + (j * j) + m) % (i * j) == 0) {
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
