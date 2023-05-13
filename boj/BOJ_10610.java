package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 30
 * https://www.acmicpc.net/problem/10610
 */
public class BOJ_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (sum % 3 != 0 || arr[0] != '0') {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
