package boj;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/6588
public class BOJ_6588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check[] = new boolean[1000001];
        check[0] = check[1] = true;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i * i < 1000000; i++) {
            if (check[i] == false) {
                arr.add(i);
                for (int j = i+i; j < 1000000; j += i) {
                    check[j] = true;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            for (int i = 1; i < arr.size(); i++) {
                int p = arr.get(i);
                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + "+" + (n - p));
                    break;
                }
            }

        }
    }
}
