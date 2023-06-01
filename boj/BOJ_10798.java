package boj;

import java.util.Scanner;

/**
 * 세로읽기
 * https://www.acmicpc.net/problem/10798
 */
public class BOJ_10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Character[][] arr = new Character[5][15];
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String s = sc.next();
            maxLength = Math.max(maxLength, s.length());
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] =  s.charAt(j);
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != null) {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
