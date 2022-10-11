package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 완전제곱수
 * https://www.acmicpc.net/problem/1977
 */
public class BOJ_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            double k = Math.sqrt(i);
            if (Math.ceil(k) == Math.floor(k)) {
                arr.add(i);
            }
        }

        if (arr.size() > 0) {
            Collections.sort(arr);
            int sum = arr.stream().mapToInt(Integer::valueOf).sum();
            System.out.println(sum + "\n" + arr.get(0));
        } else {
            System.out.println(-1);
        }
    }
}
