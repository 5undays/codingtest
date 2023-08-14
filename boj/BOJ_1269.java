package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 대칭 차집합
 * https://www.acmicpc.net/problem/1269
 */
public class BOJ_1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a + b; i++) {
            int k = sc.nextInt();
            if (set.contains(k)) {
                set.remove(k);
            } else {
                set.add(k);
            }
        }

        System.out.println(set.size());
    }
}
