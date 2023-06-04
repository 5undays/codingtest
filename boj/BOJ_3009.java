package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 네 번째 점
 * https://www.acmicpc.net/problem/3009
 */
public class BOJ_3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (arr.contains(x)) {
                arr.remove(arr.indexOf(x));
            } else {
                arr.add(x);
            }

            if (arr2.contains(y)) {
                arr2.remove(arr2.indexOf(y));
            } else {
                arr2.add(y);
            }
        }

        System.out.println(arr.get(0) + " " + arr2.get(0));
    }
}
