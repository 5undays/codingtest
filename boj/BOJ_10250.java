package boj;

import java.util.Scanner;

/**
 * ACM 호텔
 * https://www.acmicpc.net/problem/10250
 */
public class BOJ_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int h = sc.nextInt(); // 세로
            int w = sc.nextInt(); // 가로
            int guest = sc.nextInt(); // 손님
            int current = 0;
            int answer = 0;
            for (int j = 1; j <= w; j++) {
                if (answer == 0) {
                    for (int e = 1; e <= h; e++) {
                        if (current == guest - 1) {
                            answer = e * 100 + j;
                            break;
                        }
                        current++;
                    }
                }
            }
            System.out.println(answer);
        }
    }   
}
