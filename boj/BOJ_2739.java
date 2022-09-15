package boj;

import java.util.Scanner;

public class BOJ_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            sb.append(n + " * " + i + " = " + n * i).append("\n");
        }
        System.out.println(sb);
    }
}
