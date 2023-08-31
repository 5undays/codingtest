package boj;

import java.util.Scanner;

/**
 * 심부름 가는 길
 * https://www.acmicpc.net/problem/5554
 */
public class BOJ_5554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = 0, minute = 0;
        for (int i = 0; i < 4; i++) {
            int k = sc.nextInt();
            hour += k / 60;
            minute += k % 60;
        }

        int time = minute / 60;
        if (time > 0) {
            hour += time;
            minute -= time * 60;
        }
        System.out.println(hour + "\n" + minute);
    }
}
