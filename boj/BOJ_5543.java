package boj;

import java.util.Scanner;

public class BOJ_5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int burger = 2000;
        for (int i = 0; i < 3; i++) {
            burger = Math.min(burger, sc.nextInt());
        }

        int drink = 2000;
        for (int i = 0; i < 2; i++) {
            drink = Math.min(drink, sc.nextInt());
        }

        System.out.println(burger + drink - 50);
    }
}
