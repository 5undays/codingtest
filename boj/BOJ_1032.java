package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 명령 프롬프트
 * https://www.acmicpc.net/problem/1032
 */
public class BOJ_1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Boolean[] arr2 = new Boolean[arr[0].length()];
        Arrays.fill(arr2, true);
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            for (int j = i + 1; j < n; j++) {
                String diff = arr[j];
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) != diff.charAt(k)) {
                        arr2[k] = false;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i]) {
                sb.append(arr[0].charAt(i));
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb);
    }
}
