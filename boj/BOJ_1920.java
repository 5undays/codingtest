package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            if (list.contains(b)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
