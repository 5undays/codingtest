package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 약수
 * https://www.acmicpc.net/problem/1037
 */
public class BOJ_1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);
        System.out.println(arr.get(0) * arr.get(arr.size() - 1));
    }
}
