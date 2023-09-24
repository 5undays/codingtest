package boj;

import java.util.Scanner;

public class BOJ_7891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}
