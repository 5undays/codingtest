package boj;

import java.util.Scanner;

public class BOJ_2845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int p = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int k = sc.nextInt();
            sb.append(k - (l * p)).append(" ");
        }
        System.out.println(sb);
    }
}
