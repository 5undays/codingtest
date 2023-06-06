package boj;

import java.util.Scanner;

/**
 * 다이얼
 * https://www.acmicpc.net/problem/5622
 */
public class BOJ_5622 {
    static String[] arr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains(s.charAt(i) + "")) {
                    answer += j + 3;
                }
            }
        }
        System.out.println(answer);
    }
}
