package boj;

import java.util.Scanner;

/**
 * 소수 구하기
 * https://www.acmicpc.net/problem/1929
 */
public class BOJ_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[N + 1];
        /**
         * 2보다 작은 수는 무시하고 소수에 해당되는 값만 true로 변경 
         * */ 
        for (int i = 2; i <= N; i++) {
            if (prime[i])
                continue;
            if (i >= M)
                sb.append(i).append("\n");
            for (int j = i + i; j <= N; j += i) {
                prime[j] = true;
            }
        }   
        System.out.println(sb);
    }

}
