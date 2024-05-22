package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 골드바흐의 추측
 * https://www.acmicpc.net/problem/6588
 */
public class BOJ_6588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check[] = new boolean[1000001];
        check[0] = check[1] = true;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i < Math.sqrt(1000000); i++) {
            if (!check[i]) {
                arr.add(i);
                for (int j = i * i; j < 1000000; j += i) {
                    check[j] = true;
                }
            }
        }

        boolean notFound = true;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            for (int i = 1; i < n / 2 + 1; i++) {
                int p = arr.get(i);
                if (!check[n - p] && !check[p]) {
                    sb.append(n + " = " + p + " + " + (n - p)).append("\n");
                    notFound = false;
                    break;
                }
            }
        }

        if (notFound) {
            System.out.println("Goldbach's conjecture is wrong.");
        } else {
            System.out.println(sb);
        }
    }
}
