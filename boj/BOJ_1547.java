package boj;

import java.util.Scanner;

public class BOJ_1547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int answer = 1;
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == answer) {
                answer = y;
            } else if (y == answer) {
                answer = x;
            }
        }
        System.out.println(answer);
    }
}
