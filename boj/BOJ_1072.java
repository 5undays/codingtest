package boj;

import java.util.Scanner;

/**
 * 게임
 * https://www.acmicpc.net/problem/1072
 */
public class BOJ_1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 게임 횟수
        int y = sc.nextInt(); // 이긴 게임
        sc.close();
        int z = getPercent(x, y);
        int min = 0;
        int max = (int) 1e9;
        int answer = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (getPercent(x + mid, y + mid) != z) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}