package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 단어의 개수
 * https://www.acmicpc.net/problem/1152
 */
public class BOJ_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        System.out.println(st.countTokens());
        sc.close();
    }
}
