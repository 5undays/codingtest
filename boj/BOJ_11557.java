package boj;

import java.util.Scanner;

public class BOJ_11557 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int max = 0;
            String name = "";
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                int l = sc.nextInt();
                if (max < l) {
                    name = s;
                    max = l;
                }
            }
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
