package boj;

import java.util.Scanner;

public class BOJ_2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1, y = 1, max = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int k = sc.nextInt();
                if (k > max && k > 0) {
                    max = k;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max + "\n" + x + " " + y);
    }
}
