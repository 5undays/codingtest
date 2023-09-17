package boj;

import java.util.Scanner;

public class BOJ_19944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n >= m && m > 2) {
            System.out.println("OLDBIE!");
        } else if (m <= 2) {
            System.out.println("NEWBIE!");
        } else {
            System.out.println("TLE!");
        }
    }
}
