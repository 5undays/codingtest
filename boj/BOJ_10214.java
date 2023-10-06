package boj;

import java.util.Scanner;

public class BOJ_10214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int k = 0, y = 0;
            for (int i = 0; i < 9; i++) {
                y += sc.nextInt();
                k += sc.nextInt();
            }
            if (k > y) {
                sb.append("Korea");
            } else if (k < y) {
                sb.append("Yonsei");
            } else {
                sb.append("Draw");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
