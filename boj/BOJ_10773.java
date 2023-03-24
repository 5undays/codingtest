package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 제로
 * https://www.acmicpc.net/problem/10773
 */
public class BOJ_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                arr.remove(arr.size() - 1);
            } else {
                arr.add(x);
            }
        }

        for (int x : arr) {
            answer += x;
        }

        System.out.println(answer);
    }
}
