package boj;

import java.util.Scanner;

/**
 * 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 */
public class BOJ_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 97] == -1) {
                arr[s.charAt(i) - 97] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
