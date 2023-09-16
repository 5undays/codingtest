package boj;

import java.util.Scanner;

public class BOJ_13752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sb.append("=".repeat(sc.nextInt())).append("\n");
        }
        System.out.println(sb);
    }
}
