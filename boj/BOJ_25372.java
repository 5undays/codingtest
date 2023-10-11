package boj;

import java.util.Scanner;

public class BOJ_25372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ;i++) {
            String k = sc.next();
            if (k.length() >= 6 && k.length() <= 9) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
